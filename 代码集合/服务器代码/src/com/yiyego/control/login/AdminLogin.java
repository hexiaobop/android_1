package com.yiyego.control.login;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yiyego.databaseuntil.AdminDaoimpl;
import com.yiyego.databaseuntil.GoodsDaoImpl;
import com.yiyego.pojo.Goods;
import com.yiyego.pojo.Page;

@Controller
public class AdminLogin {
	
	boolean flag = true;
	@RequestMapping(value="/admin/login",method = RequestMethod.POST)
	
	public String adduser(String username,String password)
	{
		System.out.println(username);
		System.out.println(password);
	AdminDaoimpl adp = new AdminDaoimpl();
	if(adp.login(username, password))
	{
		System.out.println("密码正确");
		flag = true;
		return "redirect:/admin/adminindex";
	}
		
	else
	{
		return "/index?page1=1";
	}
	
	}
	
	
	
	
	
	
	
	@RequestMapping("/admin/adminindex")
	public ModelAndView yanzhengindex ()
	{
		String s;
		String page1 ="1";
		if(flag)
		{
			s= "/admin/adminindex";
			List<Goods> list =null;
			GoodsDaoImpl goodssimpl = new GoodsDaoImpl();
			int number = goodssimpl.pagenumber();
			int page;
			Page pa = new Page();
			
			if(number%10==0)
			{
				page = number/10;
			}
			else{
				page = number/10+1;
			}
			
			if(page1==null||page1.equals(""))
			{
				page1 = "1";
			}
			else if(Integer.parseInt(page1)<=0||Integer.parseInt(page1)>page)
			{
				page1="1";
			}
			
		System.out.println("请求的页数"+page1);	
		
		try {
			
			list = goodssimpl.findall(Integer.parseInt(page1));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		}	
		pa.setNowpage(Integer.parseInt(page1));
		pa.setPagetotal(page);
		pa.setLasturl("http://younger/1130huadian/?page1"+"="+page);
		pa.setGoodsnumber(number);
		
		ModelAndView modelAndView = new ModelAndView(s);  
	    modelAndView.addObject("list", list); 
	    modelAndView.addObject("number",number);
	    modelAndView.addObject("page",page);
	    modelAndView.addObject("page",pa);    
	    return modelAndView; 
		
		}
			
		
		else
		{
			s="/index?page1=1";
			ModelAndView modelAndView = new ModelAndView(s);
			return modelAndView;
		}
		
		
	}
	
	
}
