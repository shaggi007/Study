package com.capgemini.exception;

public class NegativeEmployeeIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "NegativeEmployeeIdException";
	}

	@Override
	public String getMessage() {
		return "Employee id can not be negative";
	}
	
}
