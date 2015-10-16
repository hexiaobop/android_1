package com.yiyego.databaseuntil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.yiyego.Dao.GoodsDao;
import com.yiyego.pojo.Goods;

public class GoodsDaoImpl implements GoodsDao{
	private Connection conn;
	@Override
	public List<Goods> findall(int style_id,int page) throws ClassNotFoundException, SQLException {
		 String SQL_FIND ="select goods_id,name,price,introduce,imageurl,selltotal,detailurl,style_id from goods where style_id=? limit ?,8";
		// TODO Auto-generated method stub
		conn =(Connection) DbConnect.getConnection() ;
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL_FIND);
		pstmt.setInt(1, style_id);
		pstmt.setInt(2,(page-1)*6);
		
		ResultSet result = (ResultSet) pstmt.executeQuery();
		List<Goods> list = new ArrayList<Goods>();
		while(result.next())
		{
			Goods goods =new Goods();
			goods.setName(result.getString("name"));			
			goods.setPrice(result.getInt("price"));		
			goods.setIntroduce(result.getString("introduce"));
			goods.setSelltotal(result.getString("selltotal"));
			goods.setDetailurl(result.getString("detailurl"));
			goods.setImageurl(result.getString("imageurl"));
			goods.setGoods_id(result.getInt("goods_id"));	
			goods.setStyle_id(result.getInt("style_id"));
			System.out.println(result.getString("style_id"));
			list.add(goods);
		}
		return list;
	}
	public int pagenumber()
	{
		int number =0;
		String SQL_ALL = "select count(*) from goods";
		try {
			conn =(Connection) DbConnect.getConnection() ;
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL_ALL);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			while(rs.next())
			{
				number=rs.getInt(1);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
		
	}
	
	
	public List<Goods> findall(int page) throws ClassNotFoundException, SQLException {
		 String SQL_FIND ="select goods_id,name,price,introduce,imageurl,selltotal,detailurl,style_id from goods limit ?,10";
		// TODO Auto-generated method stub
		conn =(Connection) DbConnect.getConnection() ;
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL_FIND);
	
		pstmt.setInt(1,(page-1)*10);
		
		ResultSet result = (ResultSet) pstmt.executeQuery();
		List<Goods> list = new ArrayList<Goods>();
		while(result.next())
		{
			Goods goods =new Goods();
			goods.setName(result.getString("name"));			
			goods.setPrice(result.getInt("price"));		
			goods.setIntroduce(result.getString("introduce"));
			goods.setSelltotal(result.getString("selltotal"));
			goods.setDetailurl(result.getString("detailurl"));
			goods.setImageurl(result.getString("imageurl"));
			goods.setGoods_id(result.getInt("goods_id"));	
			goods.setStyle_id(result.getInt("style_id"));
			System.out.println(result.getString("style_id"));
			list.add(goods);
		}
		return list;
	}
//	public int pagenumber()
//	{
//		int number =0;
//		String SQL_ALL = "select count(*) from goods";
//		try {
//			conn =(Connection) DbConnect.getConnection() ;
//			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL_ALL);
//			ResultSet rs = (ResultSet) pstmt.executeQuery();
//			while(rs.next())
//			{
//				number=rs.getInt(1);
//			}
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return number;
//		
//	}
	
	

}
