package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
@Service
public class OTPService {
	private static final long OTP_VALID_DURATION_MS=120*1000;
	private Map<String, OtpData> otpMap=new HashMap<>();
	public String generateOtp(String userEmail) {
		String otp=generateRandomOtp();
		otpMap.put(userEmail,new OtpData(otp));
		return otp;
	}
	private String generateRandomOtp() {
		return RandomStringUtils.randomNumeric(6);
	}
	private static class OtpData {
		private String otp;
		private long creationTime;
		public OtpData(String otp) {
			super();
			this.otp = otp;
			this.creationTime = System.currentTimeMillis();
		}
		public boolean isValid(String enteredOtp) {
			long currentTime=System.currentTimeMillis();
			return currentTime - creationTime <= OTP_VALID_DURATION_MS && otp.equals(enteredOtp);
		}
		public long getCreationTime() {
			return creationTime;
		}
	}
	public boolean validateOtp(String userEmail,String enteredOtp) {
		OtpData otpData=otpMap.get(userEmail);
		if(otpData!=null&&otpData.isValid(enteredOtp)) {
			otpMap.remove(userEmail);
			return true;
		}
		return false;
	}


}
