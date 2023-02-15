package com.petshopproject.exception;

public class CustomException extends Exception {
	
	private String errorMessage;

	public CustomException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	// Overriding the getMessage() method, which comes from Exception Class, to show our custom error message.
	
	@Override
	public String getMessage() {
		
		return this.errorMessage;
	}
	
	
}
