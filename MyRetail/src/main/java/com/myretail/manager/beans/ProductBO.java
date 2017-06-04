/**
 * 
 */
package com.myretail.manager.beans;

/**
 * This is a business object that has product name and its price details.
 * 
 * @author Muktevi
 *
 */
public class ProductBO {

	private Long id;
	private String name;
	private CurrentPrice currentPrice;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}
}
