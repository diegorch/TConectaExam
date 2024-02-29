package com.bimbonet.tconecta.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "REWARDS")
public class RewardModel implements Serializable{
	
	private static final long serialVersionUID = 3891826689883663133L;

	@Id
	@Column (name="REWARDID",  nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long rewardID;

	@Column (name="REWARDNAME")
	private String rewardName;

	@Column (name="QTY")
	private int qty;

	@Column (name="PRICEPOINTS")
	private int pricePoints;

	/**
	 * @param productID
	 * @param productName
	 * @param qty
	 * @param price
	 */
	public RewardModel(Long rewardID, String rewardName, int qty, int pricePoints) {
		super();
		this.rewardID = rewardID;
		this.rewardName = rewardName;
		this.qty = qty;
		this.pricePoints = pricePoints;
	}

	/**
	 * 
	 */
	public RewardModel() {
		super();
	}

	/**
	 * @return the rewardID
	 */
	public Long getRewardID() {
		return rewardID;
	}

	/**
	 * @param rewardID the rewardID to set
	 */
	public void setRewardID(Long rewardID) {
		this.rewardID = rewardID;
	}

	/**
	 * @return the productName
	 */
	public String getRewardName() {
		return rewardName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
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
	 * @return the pricePoints
	 */
	public int getPricePoints() {
		return pricePoints;
	}

	/**
	 * @param pricePoints the pricePoints to set
	 */
	public void setPricePoints(int pricePoints) {
		this.pricePoints = pricePoints;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
