package com.yiyego.Dao;

import java.sql.SQLException;
import java.util.List;

import com.yiyego.pojo.User;

public interface UserDao {
	
	public User findbyname(String name,String userpassword);  //登录
	
	public boolean existbyname(String name);                    //判断是否有用户名 
	public int  adduser(User user);							   //注册
	public int  deleteuser(User user);
	public int  updateuser(User user);
	public List<User> findall() ;
	

}
