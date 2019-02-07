package com.capgemini.exception;

public class NameNullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "NameNullException";
	}

	@Override
	public String getMessage() {
		return "Name can not be null";
	}
	
}
