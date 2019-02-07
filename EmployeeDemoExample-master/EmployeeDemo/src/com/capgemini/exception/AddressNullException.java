package com.capgemini.exception;

public class AddressNullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "AddressNullException";
	}

	@Override
	public String getMessage() {
		return "Address can not be null";
	}
	
}
