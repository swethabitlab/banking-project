package com.example.service;

import com.example.dto.AccountResponse;
import com.example.dto.UserResponse;

public interface DashboardService {

	UserResponse getUserDetails(String accountNumber);
    AccountResponse getAccountDetails(String accountNumber);
}
