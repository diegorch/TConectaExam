package com.bimbonet.tconecta.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "PRODUCTS")
public class ProductsModel implements Serializable{
	
	private static final long serialVersionUID = 6100445806167234289L;

	@Id
	@Column (name="PRODUCTID",  nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long productID;

	@Column (name="PRODUCTNAME")
	private String productName;

	@Column (name="QTY")
	private int qty;

	@Column (name="PRICE")
	private double price;

	@Column (name="LOYALTYPOINTS")
	private int loyaltyPoints;

	/**
	 * @param productID
	 * @param productName
	 * @param qty
	 * @param price
	 * @param loyaltyPoints
	 */
	public ProductsModel(Long productID, String productName, int qty, double price, int loyaltyPoints) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.qty = qty;
		this.price = price;
		this.loyaltyPoints = loyaltyPoints;
	}

	/**
	 * 
	 */
	public ProductsModel() {
		super();
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
