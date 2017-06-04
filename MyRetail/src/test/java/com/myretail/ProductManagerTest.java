/**
 * 
 */
package com.myretail;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myretail.dao.PriceRepository;
import com.myretail.dao.beans.PriceDO;
import com.myretail.manager.ProductManager;
import com.myretail.manager.beans.ProductBO;
import com.myretail.service.ProductService;
import com.myretail.service.beans.ProductSO;

/**
 * @author Muktevi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductManagerTest {

	@InjectMocks private ProductManager productManager;
	@Mock private PriceRepository priceRepoitory;
	@Mock private ProductService productService;
	public static Long id = 13860428l;
	
	@Test
	public void getProductDetailsTest() throws Exception{
		PriceDO priceDO = new PriceDO();
		priceDO.setCurrency("USD");
		priceDO.setPrice(40.4f);
		priceDO.setProductId(id);
		ProductSO productSO = new ProductSO();
		productSO.setName("Game of Thrones");
		System.out.println("##################");
		Mockito.when(productService.getProductDetails(id)).thenReturn(productSO);
		System.out.println("++++++++++++++++++");
		Mockito.when(priceRepoitory.getProductPrice(id)).thenReturn(priceDO);
		System.out.println("******************");
		ProductBO productBO= productManager.getProductDetails(id);
		assertEquals(priceDO.getProductId(), productBO.getId());
		assertEquals(priceDO.getCurrency(), productBO.getCurrentPrice().getCurrency());
		assertEquals(priceDO.getPrice(), productBO.getCurrentPrice().getPrice());
		assertEquals(productSO.getName(),productBO.getName());
		
	}
	
	@Test
	public void populateProductBOTest(){
		PriceDO priceDO = new PriceDO();
		priceDO.setCurrency("USD");
		priceDO.setPrice(100.4f);
		priceDO.setProductId(id);
		ProductSO productSO = new ProductSO();
		productSO.setName("Prison Break");
		
		ProductBO productBO = productManager.populateProductBO(priceDO,productSO);
		
		assertEquals(priceDO.getProductId(), productBO.getId());
		assertEquals(priceDO.getCurrency(), productBO.getCurrentPrice().getCurrency());
		assertEquals(priceDO.getPrice(), productBO.getCurrentPrice().getPrice());
		assertEquals(productSO.getName(),productBO.getName());
		
	}
}
