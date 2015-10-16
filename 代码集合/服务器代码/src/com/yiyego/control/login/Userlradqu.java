package com.yiyego.control.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiyego.databaseuntil.UserDaoimpl;
import com.yiyego.pojo.User;


@Controller
public class Userlradqu {	
	UserDaoimpl userdaoimpl = new UserDaoimpl();
	@RequestMapping(value="/user/login",method = RequestMethod.POST)
	@ResponseBody
	public String userlogin(String username,String password)
	{	
		String flag=null;
		String str;
		User user = new User();
		
		System.out.println(username);
		System.out.println(password);
		if((user=userdaoimpl.findbyname(username, password))!=null)
		{
			if(user.getSex().equals("ÄĞ"))
			{
				str="boy";
			}
			else{
				str = "girl";
			}
			flag = "success"+str;
			System.out.println(flag);
		}
		else
		{
			flag = "fail";
		}
		return flag;
	
	}
	
	@RequestMapping(value="/user/register",method = RequestMethod.POST)
	@ResponseBody

	public String register(String username,String password,String phone,String sex)
	{
		String flag=null;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setSex(sex);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		if(userdaoimpl.adduser(user)>0)
		{
			flag = "success";
		}
		else
		{
			flag = "fail";
		}
		return flag;
		
	}

}
