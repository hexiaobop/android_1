package com.yiyego.server;

import java.util.List;

import com.yiyego.Dao.UserDao;
import com.yiyego.pojo.User;

public class UserServer implements UserDao {

	@Override
	public User findbyname(String name, String userpassword) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean existbyname(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int adduser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteuser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateuser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}
