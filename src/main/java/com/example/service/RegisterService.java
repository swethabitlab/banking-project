package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.entity.User;
import com.example.repository.AccountRepository;
import com.example.repository.UserRepository;

@Service
public class RegisterService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordencoder;
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
		}
	public ResponseEntity<String> saveuser(User user) {
		 
	     if (userRepository.existsByEmail(user.getEmail())) {
	         return ResponseEntity.badRequest().body("Email already registered");

	     }

	   	     user.setPassword(passwordencoder.encode(user.getPassword()));
	        	     userRepository.save(user);
	     return ResponseEntity.ok(" registered successfully");

	}

}
