package com.cognizant.medicarecenter.exception;


public class UserAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public UserAlreadyExistsException(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return this.msg;
	}
}
