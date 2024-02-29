package com.bimbonet.tconecta.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "PURCHASES")
public class PurchaseModel implements Serializable{

	private static final long serialVersionUID = 2944467496722210923L;

	@Id
	@Column (name="ID",  nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="PURCHASENUMBER")
	private Long purchaseNumber;
	
	@Column (name="USERID")
	private Long userID;
	
	@Column (name="PRODUCTID")
	private Long productID;

	@Column (name="QTY")
	private int qty;

	@Column (name="LOYALTYPOINTS")
	private int loyaltyPoints;

	/**
	 * @param id
	 * @param purchaseNumber
	 * @param userID
	 * @param productID
	 * @param qty
	 * @param loyaltyPoints
	 */
	public PurchaseModel(Long id, Long purchaseNumber, Long userID, Long productID, int qty, int loyaltyPoints) {
		super();
		this.id = id;
		this.purchaseNumber = purchaseNumber;
		this.userID = userID;
		this.productID = productID;
		this.qty = qty;
		this.loyaltyPoints = loyaltyPoints;
	}

	/**
	 * 
	 */
	public PurchaseModel() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the purchaseNumber
	 */
	public Long getPurchaseNumber() {
		return purchaseNumber;
	}

	/**
	 * @param purchaseNumber the purchaseNumber to set
	 */
	public void setPurchaseNumber(Long purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
