/**
 * 
 */
package com.myretail.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myretail.service.beans.ProductSO;

/**
 * This class is responsible for performing a HTTP call to a third party API.
 * 
 * @author Muktevi
 *
 */
@Service
@PropertySource("classpath:global.properties")
public class ProductService {

	@Value("${endpoint.url}")
	private String baseURI; 
	@Value("${endpoint.suffix}")
	private String suffix;
	
	public static final String PRODUCT="product";
	public static final String ITEM="item";
	public static final String PRODUCT_DESCRIPTION="product_description";
	public static final String TITLE="title";

	private RestTemplate restTemplate = new RestTemplate();
	
	/**
	 * This method performs a HTTP GET call to an external service and get product details in JSON fromat.
	 * It responsible for converting the JSON string into an JSONObject and extracting the product name.
	 * 
	 * @param id
	 * @return ProductSO
	 * @throws JSONException
	 */
	public ProductSO getProductDetails(Long id) throws JSONException {
		String productJson = restTemplate.getForObject(baseURI+id+suffix, String.class);
		ProductSO productSO = extractProductName(productJson);
		return productSO;
	}
	
	public ProductSO extractProductName(String productJson) throws JSONException{
		ProductSO productSO = new ProductSO();
		JSONObject obj = new JSONObject(productJson);
		JSONObject product = obj.getJSONObject(PRODUCT);
		JSONObject item = product.getJSONObject(ITEM);
		JSONObject productDescription = item.getJSONObject(PRODUCT_DESCRIPTION);
		productSO.setName(productDescription.getString(TITLE));
		return productSO;
	}
	
}
