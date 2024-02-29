package com.bimbonet.tconecta.model;

public class MessageResponse {
	int status;
	String message;
	
	/**
	 * @param status
	 * @param message
	 */
	public MessageResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public MessageResponse() {
		super();
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
