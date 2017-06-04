/**
 * 
 */
package com.myretail.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myretail.dao.PriceRepository;
import com.myretail.dao.beans.PriceDO;
import com.myretail.manager.beans.CurrentPrice;
import com.myretail.manager.beans.ProductBO;
import com.myretail.service.ProductService;
import com.myretail.service.beans.ProductSO;

/**
 * This class is responsible for performing the business logic and data integration.
 * 
 * @author Muktevi
 *
 */
@Component
public class ProductManager {

	@Autowired
	private ProductService productService;
	@Autowired
	private PriceRepository priceRepository;
	
	/**
	 * This method calls price repository and gets the price data from the database.
	 * It also calls product service to fetch the product name.
	 * It merges the data from both the data sources and provides ProductBO object.
	 * 
	 * @param productId Get details of the product identified by this parameter.
	 * @return ProductBO ProductBO
	 * @throws Exception Generic Exception
	 */
	public ProductBO getProductDetails(Long productId) throws Exception { 
		PriceDO priceDO = priceRepository.getProductPrice(productId);
		ProductSO productSO = productService.getProductDetails(productId);
		return populateProductBO(priceDO,productSO);
	}
	
	/**
	 * This method calls the DAO layer method to update the price of given productId.
	 * 
	 * @param productId Product id to update
	 * @param price Price to update
	 * @return boolean Updated successfully or not.
	 * @throws Exception Generic exception.
	 */
	public boolean updateProductPrice(Long productId, Float price) throws Exception{
		return priceRepository.updatePrice(productId, price);
	}

	/**
	 * This method performs merge logic on PriceDO and ProductSO and returns ProductBO.
	 * @param PriceDO Data object that has price details for the product.
	 * @param ProductSO Service object that has the product name.
	 * @return ProductBO Business object that is integrated from DO and SO.
	 */
	public ProductBO populateProductBO(PriceDO priceDO, ProductSO productSO) {
		ProductBO productBO = new ProductBO();
		productBO.setName(productSO.getName());
		productBO.setId(priceDO.getProductId());
		CurrentPrice currentPrice = new CurrentPrice();
		currentPrice.setCurrency(priceDO.getCurrency());
		currentPrice.setPrice(priceDO.getPrice());
		productBO.setCurrentPrice(currentPrice);
		return productBO;
	}
	
}
