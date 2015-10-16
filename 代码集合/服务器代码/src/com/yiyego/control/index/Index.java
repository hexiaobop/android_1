package com.yiyego.control.index;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yiyego.databaseuntil.GoodsDaoImpl;
import com.yiyego.pojo.Goods;
import com.yiyego.pojo.Page;


@Controller
public class Index {	
	@RequestMapping(value ="/index",method=RequestMethod.GET)
public ModelAndView index(String page1){
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
		
	System.out.println("ÇëÇóµÄÒ³Êý"+page1);	
	
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
	
	ModelAndView modelAndView = new ModelAndView("/index/index");  
    modelAndView.addObject("list", list); 
    modelAndView.addObject("number",number);
    modelAndView.addObject("page",page);
    modelAndView.addObject("page",pa);    
    return modelAndView; 
	
	}
}
