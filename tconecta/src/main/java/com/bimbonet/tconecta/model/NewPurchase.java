package com.bimbonet.tconecta.model;

import java.util.List;

public class NewPurchase {
	Long userID;
	public List<Products> products;
	
	/**
	 * @param userID
	 * @param products
	 */
	public NewPurchase(Long userID, List<Products> products) {
		super();
		this.userID = userID;
		this.products = products;
	}
	
	/**
	 * 
	 */
	public NewPurchase() {
		super();
	}

	/**
	 * @return the userID
	 */
	public Long getUserID() {
		return userID;
	}
	
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	/**
	 * @return the products
	 */
	public List<Products> getProducts() {
		return products;
	}
	
	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Products> products) {
		this.products = products;
	}
}
