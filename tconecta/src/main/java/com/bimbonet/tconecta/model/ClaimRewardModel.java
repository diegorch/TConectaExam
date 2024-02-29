package com.bimbonet.tconecta.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "CLAIMREWARD")
public class ClaimRewardModel implements Serializable{
	
	private static final long serialVersionUID = -5242083085541215604L;

	@Id
	@Column (name="CLAIMID",  nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long claimID;
	
	@Column (name="USERID")
	private Long userID;
	
	@Column (name="REWARDID")
	private Long rewardID;

	@Column (name="QTY")
	private int qty;

	/**
	 * @param claimID
	 * @param userID
	 * @param rewardID
	 * @param qty
	 */
	public ClaimRewardModel(Long claimID, Long userID, Long rewardID, int qty) {
		super();
		this.claimID = claimID;
		this.userID = userID;
		this.rewardID = rewardID;
		this.qty = qty;
	}

	public ClaimRewardModel() {
		super();
	}

	/**
	 * @return the claimID
	 */
	public Long getClaimID() {
		return claimID;
	}

	/**
	 * @param claimID the claimID to set
	 */
	public void setClaimID(Long claimID) {
		this.claimID = claimID;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
