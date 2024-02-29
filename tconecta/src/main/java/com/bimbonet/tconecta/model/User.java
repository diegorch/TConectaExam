package com.bimbonet.tconecta.model;

public class User {
	int userID;
	String userName;
	String password;
	int loyaltyPoints;
	
	/**
	 * @param userID
	 * @param userName
	 * @param password
	 * @param loyaltyPoints
	 */
	public User(int userID, String userName, String password, int loyaltyPoints) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.loyaltyPoints = loyaltyPoints;
	}

	public User() {
		super();
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
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
