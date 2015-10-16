package com.yiyego.databaseuntil;

import org.junit.Test;

import com.yiyego.Dao.UserDao;
import com.yiyego.pojo.User;

public class UserTest {

	@Test
	public void test() {
	UserDao userd = new UserDaoimpl();
	userd.findall();
	User user =new User();
	if((user=userd.findbyname("asd", "123456"))!=null)
	{
		System.out.println(user.getUsername());
		System.out.println(user.getSex());
	}
	if(userd.existbyname("何小波"))
	{
		System.out.println("已存在用户名");
	}
	User userass = new User();
	userass.setUsername("陈诚");
	userass.setPassword("123456");
	userass.setSex("男");
	userass.setPhone("18109074597");
if(userd.adduser(userass)>0)
{
	System.out.println("注册成功");
	}
else
{
	System.out.println("注册失败");}
	}
	
	

}
