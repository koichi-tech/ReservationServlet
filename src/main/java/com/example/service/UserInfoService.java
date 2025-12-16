package com.example.service;

import java.util.List;

import com.example.model.User;
import com.example.strategy.UserInfoStrategy;

public class UserInfoService {
	
	
	private UserInfoStrategy userInfoStrategy;
	
	public UserInfoService(UserInfoStrategy userInfoStrategy) {
		this.userInfoStrategy = userInfoStrategy;
	}
	
	public List<User> checkUser(String mailAddress) {
		try {			
			return userInfoStrategy.execute(mailAddress);					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
