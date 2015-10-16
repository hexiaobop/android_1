package com.yiyego.pojo;

public class Page {
	private int nowpage;
	private int pagetotal;
	private String firsturl = "http://younger/1130huadian/";
	private String lasturl;
	private int goodsnumber;
	public int getGoodsnumber() {
		return goodsnumber;
	}
	public void setGoodsnumber(int goodsnumber) {
		this.goodsnumber = goodsnumber;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getPagetotal() {
		return pagetotal;
	}
	public void setPagetotal(int pagetotal) {
		this.pagetotal = pagetotal;
	}
	public String getFirsturl() {
		return firsturl;
	}
	public void setFirsturl(String firsturl) {
		this.firsturl = firsturl;
	}
	public String getLasturl() {
		return lasturl;
	}
	public void setLasturl(String lasturl) {
		this.lasturl = lasturl;
	}	
	
}
