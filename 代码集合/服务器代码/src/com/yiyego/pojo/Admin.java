package com.yiyego.pojo;

public class Admin {
	private int ad_id;                    //管理员id
	private String username;		     //管理员姓名
	private String adpassword;			//管理员密码
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAdpassword() {
		return adpassword;
	}
	public void setAdpassword(String adpassword) {
		this.adpassword = adpassword;
	}

}
