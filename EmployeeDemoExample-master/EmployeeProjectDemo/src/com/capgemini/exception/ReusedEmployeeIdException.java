package com.capgemini.exception;

public class ReusedEmployeeIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "ReusedEmployeeIdException";
	}

	@Override
	public String getMessage() {
		return "Employee Id is already used";
	}
	

}
