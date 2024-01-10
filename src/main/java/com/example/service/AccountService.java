package com.example.service;

import com.example.entity.Account;
import com.example.entity.User;

public interface AccountService {

	Account createAccount(User savedUser);
	boolean isPinCreated(String accountNumber);
	void createPin(String accountNumber,String password,String pin);
	void updatePin(String accountNumber,String oldPin,String password,String newPin);
	void cashDeposit(String accountNumber,String pin,double amount);
    void cashWithdrawl(String accountNumber,String pin,double amount);
    void fundTransfer(String sourceAccountNumber,String targetAccountNumber,String pin,double amount);
	
	
}
