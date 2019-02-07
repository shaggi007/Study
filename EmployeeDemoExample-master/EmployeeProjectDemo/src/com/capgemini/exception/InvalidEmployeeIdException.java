package com.capgemini.exception;

public class InvalidEmployeeIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "InvalidEmployeeIdException";
	}
	@Override
	public String getMessage() {
		return "Employee Id is not present in database";
	}

}
