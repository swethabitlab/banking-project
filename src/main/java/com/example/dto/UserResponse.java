package com.example.dto;

public class UserResponse {

	private String name;
	private String email;
	private String address;
	private String password;
	private String phone_number;
	private String accountNumber;
	private String IFSC_code;
	private String branch;
	private String account_type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIFSC_code() {
		return IFSC_code;
	}
	public void setIFSC_code(String iFSC_code) {
		IFSC_code = iFSC_code;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public UserResponse(String name, String email, String address, String phone_number, String accountNumber,
			String iFSC_code, String branch, String account_type) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone_number = phone_number;
		this.accountNumber = accountNumber;
		IFSC_code = iFSC_code;
		this.branch = branch;
		this.account_type = account_type;
	}
	public UserResponse() {
		super();
	}
	
	
}
