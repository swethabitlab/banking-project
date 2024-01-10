package com.example.exception;

public class OtpRetryLimitExceedException extends RuntimeException{

	public OtpRetryLimitExceedException(String message) {
		
		super(message);
		
	}
	

}
