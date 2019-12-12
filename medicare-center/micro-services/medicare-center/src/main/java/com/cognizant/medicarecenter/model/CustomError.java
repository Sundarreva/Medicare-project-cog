package com.cognizant.medicarecenter.model;

import java.util.Date;

public class CustomError {
	String errorMessage;
	String errorCode;
	Date timestamp;

	public CustomError(String errorMessage, String errorCode, Date timestamp) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Error [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", " + "timestamp=" + timestamp
				+ "]";
	}

}