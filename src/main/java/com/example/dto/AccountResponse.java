package com.example.dto;

public class AccountResponse {

	private String accountNumber;
	private double balance;
	private String account_type;
	private String branch;
	private String IFSC_code;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIFSC_code() {
		return IFSC_code;
	}
	public void setIFSC_code(String iFSC_code) {
		IFSC_code = iFSC_code;
	}
	public AccountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
