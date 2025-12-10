package com.example.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SignUpDto {

	private String userName;
	private Integer gender;
	private LocalDate birthday;
	private String mailAddress;
	private String userPassword;
	private String phoneNumber;

	public SignUpDto(String userName, Integer gender, LocalDate birthday, String mailAddress, String userPassword,
			String phoneNumber) {
		this.userName = userName;
		this.gender = gender;
		this.birthday = birthday;
		this.mailAddress = mailAddress;
		this.userPassword = userPassword;
		this.phoneNumber = phoneNumber;
	}

	// ------------------------------------
	// ゲッター (Getter methods)
	// ------------------------------------
	public String getUserName() { // private -> public に修正
		return userName;
	}

	public Integer getGender() { // private -> public に修正
		return gender;
	}

	public LocalDate getBirthDay() { // private -> public に修正
		return birthday;
	}

	public String getMailAddress() { // private -> public に修正
		return mailAddress;
	}

	public String getUserPassword() { // private -> public に修正
		return userPassword;
	}

	public String getPhoneNumber() { // private -> public に修正
		return phoneNumber;
	}

	// ------------------------------------
	// セッター (Setter methods)
	// ------------------------------------
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
