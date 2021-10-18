package com.yatra.exception;

/**
 * @author NavinkumarD
 *
 */
public class FlightNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FlightNotFoundException() {
		super();
	}

	public FlightNotFoundException(String message) {
		super(message);
	}

}
