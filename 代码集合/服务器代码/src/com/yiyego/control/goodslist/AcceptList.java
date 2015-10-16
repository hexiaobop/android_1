package com.yiyego.control.goodslist;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yiyego.databaseuntil.GoodsDaoImpl;
import com.yiyego.databaseuntil.GoodsListDaoimpl;
import com.yiyego.pojo.GoodsList;

@Controller
public class AcceptList {
	@RequestMapping(value="/list/accept",method = RequestMethod.POST)
	@ResponseBody
	public String acceptlist(String sendlist)
	{
		String flag;
		GoodsListDaoimpl goodslist = new GoodsListDaoimpl();
		 System.out.println(sendlist);
		 Gson gson = new Gson();  
	    GoodsList bean = gson.fromJson(sendlist,GoodsList.class );  
        if(goodslist.addlist(bean)!=0)
        {
		flag = "ok";
        }
        else
        {
        	flag ="fail";
        }
        return flag;
	}
	@RequestMapping(value="/list/send",method = RequestMethod.POST)
	@ResponseBody
	public String sendlist(String name)
	{
		System.out.println(name);
		GoodsListDaoimpl g= new GoodsListDaoimpl();
	System.out.println(g.findbyname(name));	
		
		Gson gson = new Gson();
		String s = gson.toJson(g.findbyname(name));
		return s;
		
	}

}
