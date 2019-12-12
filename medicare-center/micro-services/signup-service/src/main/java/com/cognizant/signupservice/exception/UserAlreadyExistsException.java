package com.cognizant.signupservice.exception;


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
