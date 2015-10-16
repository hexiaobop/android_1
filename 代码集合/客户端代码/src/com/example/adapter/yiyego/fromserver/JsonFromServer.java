package com.example.adapter.yiyego.fromserver;
/*
 * @黑星
 * 用于获取服务端的数据和解析成json返回需要的类型
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.example.adapter.yiyego.pojo.Goods;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class JsonFromServer {	
	
	//获取数据从服务端并返回获取到的字符串
	public static String jsonarray(String serverurl){
		String sss=null;
		try {
			URL url = new URL(serverurl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader reader = new BufferedReader(in);
			String result;					
			while((result = reader.readLine())!=null)
			{
				
				sss=sss+result;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String[] sss1 = sss.split("null");
		return sss = sss1[1];		
	}
	
	
	//将服务端的jsonarray解析成  collection
	public static List<Goods> jsonarraytocollection(String jsonarray)
	{
		Gson gson = new Gson();
	//	List<Goods> list= 
		return gson.fromJson(jsonarray, new TypeToken<List<Goods>>(){}.getType());
	}

}
