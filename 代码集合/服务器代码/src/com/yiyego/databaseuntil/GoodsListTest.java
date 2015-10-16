package com.yiyego.databaseuntil;

import org.junit.Test;

import com.google.gson.Gson;

public class GoodsListTest {

	@Test
	public void test() {
		GoodsListDaoimpl g= new GoodsListDaoimpl();
		g.findbyname("cc");		
		Gson gson = new Gson();
		String s = gson.toJson(g.findbyname("cc"));
		System.out.println(s);		
	}

}
