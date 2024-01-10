package com.example.exception;

public class AccountDoesNotExistsException extends RuntimeException{

	public AccountDoesNotExistsException(String message) {
		super(message);
		
	}

	
}
