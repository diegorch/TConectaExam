package com.bimbonet.tconecta.model;

import java.util.List;

public class Purchase {
	public Long purchaseID;
	public String userName;
	public Long userID;
	public List<Products> products;
	
	/**
	 * @param purchaseID
	 * @param userName
	 * @param userID
	 * @param products
	 */
	public Purchase(Long purchaseID, String userName, Long userID, List<Products> products) {
		super();
		this.purchaseID = purchaseID;
		this.userName = userName;
		this.userID = userID;
		this.products = products;
	}

	/**
	 * 
	 */
	public Purchase() {
		super();
	}

	/**
	 * @return the purchaseID
	 */
	public Long getPurchaseID() {
		return purchaseID;
	}

	/**
	 * @param purchaseID the purchaseID to set
	 */
	public void setPurchaseID(Long purchaseID) {
		this.purchaseID = purchaseID;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * @param products the products to add
	 */
	public void addProduct(Products product) {
		this.products.add(product);
	}
}
