package com.yiyego.pojo;

public class User {
	private int user_id;                 //用户id
	private String username;			 //用户名
	private String password;			 //密码
	private String registertime;
	private String phone;
	private String sex;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}
	public User(int user_id, String username, String password,
			String registertime, String phone, String sex) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.registertime = registertime;
		this.phone = phone;
		this.sex = sex;
	}
	public User() {
		super();
		
	}
	
	
	

}
