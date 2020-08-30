package com.audronfs.rocketsci.exception;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
		super("Invalid input. Please, check the example format");
	}

	public InvalidInputException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}