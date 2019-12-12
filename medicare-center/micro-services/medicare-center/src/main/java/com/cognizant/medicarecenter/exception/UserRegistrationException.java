package com.cognizant.medicarecenter.exception;

public class UserRegistrationException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	private String msg;

	public UserRegistrationException(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return this.msg;
	}

}
