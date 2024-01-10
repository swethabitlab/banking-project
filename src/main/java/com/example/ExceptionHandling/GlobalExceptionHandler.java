package com.example.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.InsufficientBalanceException;
import com.example.exception.InvalidJwtTokenException;
import com.example.exception.InvalidOtpException;
import com.example.exception.NotFoundException;
import com.example.exception.OtpRetryLimitExceedException;
import com.example.exception.UnauthorizedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(NotFoundException.class)
	    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }

	    @ExceptionHandler(UnauthorizedException.class)
	    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
	    }

	    @ExceptionHandler(InvalidJwtTokenException.class)
	    public ResponseEntity<String> handleInvalidJwtTokenException(InvalidJwtTokenException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }

	    @ExceptionHandler(InsufficientBalanceException.class)
	    public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }
	    
	    @ExceptionHandler(OtpRetryLimitExceedException.class)
	    public ResponseEntity<String> handleOtpRetryLimitExceededException(OtpRetryLimitExceedException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }
	    
	    @ExceptionHandler(InvalidOtpException.class)
	    public ResponseEntity<String> handleInvalidOTPException(InvalidOtpException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }
}
