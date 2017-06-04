/**
 * 
 */
package com.myretail.dao;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.myretail.dao.beans.PriceDO;

/**
 * This is the DAO layer to interact with the database and fetch the price and currency for the given product.
 * 
 * @author Muktevi
 *
 */
public interface PriceRepository extends CrudRepository<PriceDO, String>{
	
	/**
	 * This method queries the database and gets the price details for the given productId.
	 * @param productId Product id to be 
	 * @return PriceDO
	 */
	
	@Query("SELECT product_id,currency,price FROM product_pricing WHERE product_id=?0")
	public PriceDO getProductPrice(Long productId);
	
	/**
	 * This method updates the price value for a given productId in the database.
	 * @param productId
	 * @param prices
	 * @return boolean
	 */
	
	@Query("UPDATE test.product_pricing SET price=?1 WHERE product_id=?0 IF EXISTS")
	public boolean updatePrice(Long productId, Float prices);
}
