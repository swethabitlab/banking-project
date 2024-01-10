package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OtpInfo;

public interface OtpInfoRepository extends JpaRepository<OtpInfo, Long>{

	OtpInfo findByAccountNumberAndOtp(String accountNumber,String otp);
	OtpInfo findByAccountNumber(String accountNumber);
}
