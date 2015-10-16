package com.yiyego.control;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiyego.databaseuntil.GoodsDaoImpl;
import com.yiyego.pojo.Goods;


@Controller
public class GoodsList
{
	@RequestMapping(value ="/goods",method=RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	
public String findallGoods(int style_id,int page)	
{		
		GoodsDaoImpl goodssimpl = new GoodsDaoImpl();
		JSONArray json1 =null;
		try {
			List<Goods> list1 =goodssimpl.findall(style_id,page);
			json1	= JSONArray.fromObject(list1);   
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		System.out.println(goodssimpl.pagenumber());
		
		
		return json1.toString();		
		}
	
	@RequestMapping(value ="/goodspc",method=RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	
public String findallGoodspc(int page)	
{		
		GoodsDaoImpl goodssimpl = new GoodsDaoImpl();
		JSONArray json1 =null;
		try {
			List<Goods> list1 =goodssimpl.findall(page);
			json1	= JSONArray.fromObject(list1);   
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		System.out.println(goodssimpl.pagenumber());
		
		
		return json1.toString();		
		}
	
	

	
	
	
	@RequestMapping(value ="/test",method=RequestMethod.GET)
	@ResponseBody
public String findallGoods()	
{
		
		return  "ÄãºÃ";
	
		
		

}
}
