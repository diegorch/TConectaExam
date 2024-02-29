package com.bimbonet.tconecta.model;

public class ClaimReward {
	Long claimID;
	String usernName;
	String rewardName;
	int qty;
	
	/**
	 * @param claimID
	 * @param usernName
	 * @param rewardName
	 * @param qty
	 */
	public ClaimReward(Long claimID, String usernName, String rewardName, int qty) {
		super();
		this.claimID = claimID;
		this.usernName = usernName;
		this.rewardName = rewardName;
		this.qty = qty;
	}

	public ClaimReward() {
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
	 * @return the usernName
	 */
	public String getUsernName() {
		return usernName;
	}

	/**
	 * @param usernName the usernName to set
	 */
	public void setUsernName(String usernName) {
		this.usernName = usernName;
	}

	/**
	 * @return the rewardName
	 */
	public String getRewardName() {
		return rewardName;
	}

	/**
	 * @param rewardName the rewardName to set
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
}
