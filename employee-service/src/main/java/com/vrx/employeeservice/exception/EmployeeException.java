package com.vrx.employeeservice.exception;

public class EmployeeException extends Exception {

	public EmployeeException() {

	}

	public EmployeeException(String message) {
		super(message);
	}

	public EmployeeException(Throwable cause) {
		super(cause);
	}

	public EmployeeException(String message, Throwable cause) {
		super(message, cause);
	}

	protected EmployeeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
