package com.example.strategy;

import java.util.List;

import com.example.dao.SignUpDao;
import com.example.dto.SignUpDto;

public class SignUpUser implements SignUpStrategy{

	private final SignUpDao signupDao;
	
	//コンストラクタの作成
	public SignUpUser(SignUpDao signupDao) {
		this.signupDao = signupDao;
	}

	@	Override
	public boolean createUser(SignUpDto signupDto) {
		try {
	        // signupdao.createUser() が boolean を返すことを期待
	        boolean result = signupDao.createUser(signupDto);
	        return result; // 成功/失敗の結果をそのまま返す
	        
	    } catch (Exception e) {
	        // 想定外のシステムエラーなど、予期せぬ例外が発生した場合
	        e.printStackTrace(); 
	        return false; // 例外が発生した場合は失敗として false を返す
	    }
	}

}
