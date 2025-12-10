package com.example.strategy;

import java.util.List;

import com.example.dto.SignUpDto;

public interface SignUpStrategy {
	
	boolean createUser(SignUpDto signupDto);

}
