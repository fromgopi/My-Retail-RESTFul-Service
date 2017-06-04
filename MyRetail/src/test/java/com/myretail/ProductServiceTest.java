/**
 * 
 */
package com.myretail;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myretail.service.ProductService;
import com.myretail.service.beans.ProductSO;

/**
 * @author Muktevi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	ProductService productService; 
	public static String jsonString = "{\"product\": {\"item\": {\"product_description\": {\"title\": \"Game of Thrones\"}}}}";
	
	@Test
	public void extractProductNameTest() throws JSONException{
		ProductSO productSO = productService.extractProductName(jsonString);
		assertEquals("Game of Thrones",productSO.getName());
	}

}
