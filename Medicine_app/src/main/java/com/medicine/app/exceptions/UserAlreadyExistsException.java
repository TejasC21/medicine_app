package com.medicine.app.exceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends RuntimeException {
	
	public UserAlreadyExistsException(String msg) {
		super(msg);
	} 
}
