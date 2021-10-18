package com.yatra.exception;

/**
 * @author NavinkumarD
 *
 */
public class PassengerIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PassengerIdNotFoundException() {
		super();
	}

	public PassengerIdNotFoundException(String message) {
		super(message);
	}

}
