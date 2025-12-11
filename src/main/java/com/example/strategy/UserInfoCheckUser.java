package com.example.strategy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.UserDao;
import com.example.model.User;

import session.UserInfoSession;

public class UserInfoCheckUser implements UserInfoStrategy{
	
	
	private final UserDao userDao;
	public UserInfoCheckUser(UserDao userDao) {
		
		this.userDao=userDao;
	}
	
	@Override
	public List<User> execute(String mailAddress)throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return userDao.userInfo(mailAddress);
	}

}
