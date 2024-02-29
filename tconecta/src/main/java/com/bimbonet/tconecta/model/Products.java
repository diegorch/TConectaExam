package com.bimbonet.tconecta.model;

public class Products {
	public String productName;
	public Long productID;
	public int qty;
	public int loyaltyPoints;
	
	/**
	 * @param productName
	 * @param productID
	 * @param qty
	 * @param loyaltyPoints
	 */
	public Products(String productName, Long productID, int qty, int loyaltyPoints) {
		super();
		this.productName = productName;
		this.productID = productID;
		this.qty = qty;
		this.loyaltyPoints = loyaltyPoints;
	}

	/**
	 * 
	 */
	public Products() {
		super();
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productID
	 */
	public Long getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(Long productID) {
		this.productID = productID;
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * @return the loyaltyPoints
	 */
	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	/**
	 * @param loyaltyPoints the loyaltyPoints to set
	 */
	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}
}
