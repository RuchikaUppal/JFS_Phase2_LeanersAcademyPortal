package com.learnersacademy.admin.bean;

public class UserBean {

	private int userId;
	private String userName;
	private String password;
	private String userType;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String string) {
		this.userType = string;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
