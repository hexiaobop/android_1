package com.yiyego.databaseuntil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.yiyego.Dao.GoodsListDao;
import com.yiyego.pojo.GoodsList;

public class GoodsListDaoimpl implements GoodsListDao {
private final String SQL_ADDLIST = "insert into list (money,address,phone,goods_id,user_name,number) values (?,?,?,?,?,?)";
private final String SQL_FINABYNAME = "select * from list where user_name =?";
private Connection conn;
	@Override
	public int addlist(GoodsList goodslist) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			conn =(Connection) DbConnect.getConnection() ;			
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL_ADDLIST);
			pstmt.setString(1, goodslist.getMoney());
			pstmt.setString(2,goodslist.getAddress());
			pstmt.setString(3,goodslist.getPhone());
			pstmt.setString(4,goodslist.getGoods_id());
			pstmt.setString(5,goodslist.getUser_name());
			int i = goodslist.getGoods_id().split("#").length;
			pstmt.setInt(6, i);
			
			flag = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return flag;
	}
	public List<GoodsList> findbyname(String name)
	{
		List<GoodsList>  list = new ArrayList<GoodsList>();
		try {
			conn =(Connection) DbConnect.getConnection() ;
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL_FINABYNAME);
			pstmt.setString(1, name);
			
			ResultSet result = (ResultSet) pstmt.executeQuery();
			
				while(result.next())
				{
					GoodsList goodslist = new GoodsList();
					goodslist.setMoney(result.getString("money"));					
					goodslist.setNumber(result.getInt("number"));
					goodslist.setHappentime(result.getString("happentime"));
					list.add(goodslist);
				}	
				pstmt.close();
				conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		return list;
		
	}

}
