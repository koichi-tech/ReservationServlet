package com.example.service;

import com.example.dto.SignUpDto;
import com.example.strategy.SignUpStrategy;

public class SignUpService {
	
	private SignUpStrategy signUpStrategy;
	
	public SignUpService(SignUpStrategy signUpStrategy) {
		this.signUpStrategy = signUpStrategy;
	}
	
	public boolean executeUserCreation(SignUpDto signupDto) {
		
		return signUpStrategy.createUser(signupDto);
	}
	

}
