package com.bimbonet.tconecta.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "USERS")
public class UserModel implements Serializable{

	private static final long serialVersionUID = -5808994542982742819L;

	@Id
	@Column (name="USERID",  nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long userID;
	
	@Column (name="USERNAME")
	private String userName;
	
	@Column (name="PASSWORD")
	private String password;
	
	@Column (name="LOYALTYPOINTS")
	private Long loyaltyPoints;

	/**
	 * @param userID
	 * @param userName
	 * @param password
	 * @param loyaltyPoints
	 */
	public UserModel(Long userID, String userName, String password, Long loyaltyPoints) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.loyaltyPoints = loyaltyPoints;
	}

	/**
	 * 
	 */
	public UserModel() {
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loyaltyPoints
	 */
	public Long getLoyaltyPoints() {
		return loyaltyPoints;
	}

	/**
	 * @param loyaltyPoints the loyaltyPoints to set
	 */
	public void setLoyaltyPoints(Long loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
