package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.UserResponse;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.exception.UserValidationException;
import com.example.repository.UserRepository;
import com.example.util.LoggedinUser;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User registerUUser(User user) {
		String encodePassword=passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		
		//save user details
		User savedUser=userRepository.save(user);
		
		//create an account for user
		Account account=accountService.createAccount(savedUser);
		savedUser.setAccount(account);
		userRepository.save(savedUser);
		
		System.out.println(savedUser.getAccount().getAccountNumber());
		System.out.println(account.getUser().getName());
		
		return savedUser;
	}

	@Override
	public User getUserByAccountNumber(String account_no) {
		return userRepository.findByAccountAccountNumber(account_no);
	}

	@Override
	public User updateUser(User user) {
		User existingUser=userRepository.findByAccountAccountNumber(LoggedinUser.getAccountNumber());
		if(user.getEmail()!=null) {
			if(user.getEmail().isEmpty())
				throw new UserValidationException("name cannot be empty");
		}
		return null;
	}

}
