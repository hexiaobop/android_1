package com.yiyego.Dao;

import java.sql.SQLException;
import java.util.List;

import com.yiyego.pojo.Goods;

public interface GoodsDao {
	
	public List<Goods> findall(int style_id,int page)throws ClassNotFoundException, SQLException;

}
