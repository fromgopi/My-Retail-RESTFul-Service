/**
 * 
 */
package com.myretail.dao.beans;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
//import com.datastax.driver.mapping.annotations;

/**
 * This is a Data Object that contains the productId price and currency of a product.
 * @author Muktevi
 *
 */
@Table(value = "product_pricing")
public class PriceDO {

	@PrimaryKey
	private Long product_id;
	
	private String currency;
	private Float price;
	
	public Long getProductId() {
		return product_id;
	}
	public void setProductId(Long productId) {
		this.product_id = productId;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
