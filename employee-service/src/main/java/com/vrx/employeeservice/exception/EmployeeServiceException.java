package com.vrx.employeeservice.exception;

public class EmployeeServiceException extends EmployeeException {

	public EmployeeServiceException() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeServiceException(String message) {
		super(message);
	}

	public EmployeeServiceException(Throwable cause) {
		super(cause);
	}

	public EmployeeServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	protected EmployeeServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
