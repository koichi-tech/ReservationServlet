package com.example.strategy;

import java.util.List;

import com.example.model.User;

public interface UserInfoStrategy {
	
	List<User> execute(String mailAddress)throws Exception;

}
