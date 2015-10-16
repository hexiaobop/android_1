package com.yiyego.databaseuntil;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class GoodsDaoImplTest {
	private GoodsDaoImpl goodsimpl;

	@Test
	public void test() throws ClassNotFoundException, SQLException {	
		goodsimpl = new GoodsDaoImpl();
		goodsimpl.findall(1,1);
		System.out.println(goodsimpl.pagenumber()/6+1);
	}

	public GoodsDaoImpl getGoodsimpl() {
		return goodsimpl;
	}

	public void setGoodsimpl(GoodsDaoImpl goodsimpl) {
		this.goodsimpl = goodsimpl;
	}


	

}
