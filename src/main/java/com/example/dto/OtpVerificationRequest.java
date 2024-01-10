package com.example.dto;

public class OtpVerificationRequest {

	private String otp;
	private String email;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public OtpVerificationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
