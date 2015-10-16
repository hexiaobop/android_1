package com.example.bean;

public class User {
	private String userName;
	private String password;
	private String phone;
	private boolean sex_boy;
	public User(){}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isSex_boy() {
		return sex_boy;
	}
	public void setSex_boy(boolean sex_boy) {
		this.sex_boy = sex_boy;
	}
	
}
