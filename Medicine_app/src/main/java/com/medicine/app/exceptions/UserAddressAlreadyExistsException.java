package com.medicine.app.exceptions;

@SuppressWarnings("serial")
public class UserAddressAlreadyExistsException extends RuntimeException {
	
	public UserAddressAlreadyExistsException(String msg) {
		super(msg);
	} 
}
