package com.example.adapter.yiyego.pojo;

public class GoodsList {
	private int list_id;
	private String user_name;
	private String goods_id;
	private String address;
	private String money;
	private String phone;
	private String happentime;
	private String comment;
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getList_id() {
		return list_id;
	}
	public void setList_id(int list_id) {
		this.list_id = list_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHappentime() {
		return happentime;
	}
	public void setHappentime(String happentime) {
		this.happentime = happentime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public GoodsList(int list_id, String user_name, String goods_id,
			String address, String money, String phone, String happentime,
			String comment, int number) {
		super();
		this.list_id = list_id;
		this.user_name = user_name;
		this.goods_id = goods_id;
		this.address = address;
		this.money = money;
		this.phone = phone;
		this.happentime = happentime;
		this.comment = comment;
		this.number = number;
	}
	public GoodsList() {
		super();
	}

	
	
	
}
