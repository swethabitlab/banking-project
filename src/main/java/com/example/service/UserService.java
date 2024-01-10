package com.example.service;

import com.example.dto.UserResponse;
import com.example.entity.User;

public interface UserService {

	User saveUser(User user);
	User registerUUser(User user);
	User getUserByAccountNumber(String account_no);
	User updateUser(User user);
	
}
