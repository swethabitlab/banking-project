package com.example.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class JWTUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername( String accountNumber) throws UsernameNotFoundException {
		User user=userRepository.findByAccountAccountNumber(accountNumber);
		if(user==null) {
			throw new UsernameNotFoundException("invalid account number");
		}
		return new org.springframework.security.core.userdetails.User(user.getAccount().getAccountNumber(),
				user.getPassword(),Collections.emptyList());
	}

}
