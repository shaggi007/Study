package com.capgemini.exception;

public class AddressLineNullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "AddressLineNullException";
	}

	@Override
	public String getMessage() {
		return "Address line can not be empty";
	}
	

}
