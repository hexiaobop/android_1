package com.yiyego.Dao;

public interface AdminDao {
	
	public boolean findbyname(String username);
	public boolean login(String username,String password);	

}
