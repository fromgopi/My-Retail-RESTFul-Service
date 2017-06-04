/**
 * 
 */
package com.myretail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.exception.NotFoundException;
import com.myretail.manager.ProductManager;
import com.myretail.manager.beans.ProductBO;

/**
 * This is RESTFul service that provides API to get the product name and price.
 * It also provides API for changing the price of a product.
 * 
 * @author Muktevi
 * @version 1.0
 *
 */

@RestController
@RequestMapping("/")
public class ServiceController {
	
	@Autowired
	private ProductManager productManager;
	/**
	 * This method is to interpret the error and provide a custom error message. 
	 * @param ex exception to be handled.
	 * @return ResponseEntity<ErrorResponse> This the HTTP response entity object with custom error response object.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		
		ErrorResponse error = new ErrorResponse();
		if (ex instanceof  IllegalArgumentException ){
			error.setErrorCode(HttpStatus.BAD_REQUEST.value());
			error.setMessage (ex.getMessage());
		}else if (ex instanceof  NotFoundException){
			error.setErrorCode(HttpStatus.NOT_FOUND.value());
			error.setMessage (ex.getMessage());
		}else{
			error.setErrorCode(500);
			error.setMessage (" Unknown error occured. Contact support center");
		}
		error.setMessage (ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * This method is a HTTP GET method.
	 * It is used to get the product details and price for a given productId.
	 * @param productId Get details of the product identified by this parameter.
	 * @return ProductBO Business object that has the product name and price details. 
	 * @throws Exception Generic exception.
	 */
	@RequestMapping(method=RequestMethod.GET, value="/product/{productId}")
	public ProductBO getProductDetails(@PathVariable("productId") Long productId) throws Exception  { 
		
		 if (productId == null || productId <= 0) {
	            throw new IllegalArgumentException("The 'productId' parameter must not be null or empty or <=0");
	     }
		 ProductBO bo = productManager.getProductDetails(productId);
		 
		 if ((bo.getId() == null) || (bo.getId() == 0)){
	            throw new NotFoundException("The 'productId' Not found");
	     }
		return bo;
	}
	
	/**
	 * This method is a HTTP put method.
	 * It is used to update the price of the product for a given productId.
	 * @param productId Id of the product to be updated.
	 * @param price Price to be updated.
	 * @return boolean Updated successfully or not.
	 * @throws Exception Generic exception.
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/product/{productId}")
	public boolean updateProductPrice(@PathVariable("productId") Long productId, @RequestBody ProductBO price) throws Exception{
		
		if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("The 'productId' parameter must not be null or empty or <=0");
		}
		return productManager.updateProductPrice(productId, price.getCurrentPrice().getPrice());
	}
}
