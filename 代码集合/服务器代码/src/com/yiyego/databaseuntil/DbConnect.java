package com.yiyego.databaseuntil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnect {
	private static String driver ="com.mysql.jdbc.Driver";
	private static String url ="jdbc:mysql://localhost:3306/huadian?useUnicode=true&characterEncoding=utf-8";
	private static String user="root";
	private static String pass="";
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);		
		return conn;
	}
	
	public static void close(Connection co) throws SQLException
	{
		co.close();
	}
			

}
