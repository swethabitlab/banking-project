package com.example.dto;

public class OtpRequest {

	private String accountNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public OtpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OtpRequest(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	
}
