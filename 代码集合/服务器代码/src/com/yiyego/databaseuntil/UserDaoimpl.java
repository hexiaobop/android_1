package com.yiyego.databaseuntil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.yiyego.Dao.UserDao;
import com.yiyego.pojo.User;


public class UserDaoimpl implements UserDao {
	Connection conn =null;
	PreparedStatement pstmt;
private static final String SQL_FINDALL = "select * from user ";    //管理员
private static final String SQL_EXISTSBYNAME = "select * from user where username =?";   //查询用户名是否存在
private static final String SQL_FINDBYNAME  = "select * from user where username =?";  //登录
private static final String SQL_ADDUSER     = "insert into user (username,userpassword,phone,sex) values (?,?,?,?)"; //注册
private static final String SQL_DELETEUSER =  "delete from user where username =?";
private static final String SQL_UPDATEUSER =   "update user set username=?,userpassword=?,phone=?,sex=?";
	public List<User> findall() {
	List<User> list = new ArrayList<User>();	
			try {
				
				conn = (Connection) DbConnect.getConnection();
				pstmt =(PreparedStatement) conn.prepareStatement(SQL_FINDALL);
				ResultSet result = (ResultSet) pstmt.executeQuery();							
				while(result.next())
				{				
					User s = new User() ;
					System.out.println(result.getString("username"));				
					list.add(s);					
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			return list;
	}

	@Override
	public User findbyname(String name, String userpassword) {
		User user= new User();
		
		try {
			conn = (Connection) DbConnect.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(SQL_FINDBYNAME);
			if(existbyname(name))
			{
				pstmt.setString(1, name);
				ResultSet result = (ResultSet) pstmt.executeQuery();
				while(result.next())
				{
					if(result.getString("userpassword").equals(userpassword))
					{
						user.setUsername(result.getString("username"));
						user.setSex(result.getString("sex"));
					}
					else
					{
						user = null;
					}
				}
			}
			else
			{
				user = null;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existbyname(String name) {
		
		boolean flag=false;
		try {
			
			conn = (Connection) DbConnect.getConnection();
			PreparedStatement pstmt =(PreparedStatement) conn.prepareStatement(SQL_EXISTSBYNAME);
			pstmt.setString(1, name);
			ResultSet rs= (ResultSet) pstmt.executeQuery();
			
			if(rs.next())
			{
				
				flag=true;
			}
			else
			{
				flag=false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
		
	}

	@Override
	public int adduser(User user) {
		// TODO Auto-generated method stub
		int flag=0;
	
		try {
			conn = (Connection) DbConnect.getConnection();
			pstmt =(PreparedStatement) conn.prepareStatement(SQL_ADDUSER);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getSex());		
			if(existbyname(user.getUsername()))
			{
				flag=0;
			}
			else{
				flag = pstmt.executeUpdate();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return flag;
	}

	@Override
	public int deleteuser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateuser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
