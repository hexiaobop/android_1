package com.example.Dbh;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Handle {
	
	
	private   SQLiteDatabase db;
	

	public SQLiteDatabase getDb() {
		return db;
	}
	public void setDb(SQLiteDatabase db) {
		this.db = db;
	}
	public  SQLiteDatabase dbopen(){
		
	return db = SQLiteDatabase.openOrCreateDatabase(
     		"/data/data/com.example.flower/goods.db", null);
	}
	public void creattable()
	{
	 try{
		
		 	
	 db.execSQL("create table goods(_id integer primary key autoincrement,"
				+"goods_name varchar(50),"
				+"goods_id int,"
				+"goods_price varchar(20),"
				+"goods_imageurl varchar(100))");
	 }
	 catch (Exception e){
		 System.out.println("表已经存在");
	 }
	 }

	public  Cursor  findall() {
		// TODO Auto-generated method stub		
		Cursor cursor ;
		String sql = "select * from  goods";
		cursor = db.rawQuery(sql,null);
		
		return cursor;	
	}
	
	public boolean add(int goods_id,String goods_name,String goods_price,String goods_imageurl)
	{
		boolean flag = false;
		try{
			
			db.execSQL("insert into goods (_id,goods_id,goods_name,goods_price,goods_imageurl)  values(null,?,?,?,?)"
					,new String[]{String.valueOf(goods_id),goods_name,goods_price,goods_imageurl});
			
		
			flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
		
	}
	
	public void update()
	{
		String sql = "delete from goods where _id=1";
		db.execSQL(sql);
	}
	public  Cursor  findall(String i) {
		// TODO Auto-generated method stub		
		
		String sql = "select * from  goods";
		Cursor cursor = db.rawQuery(sql,null);
		return cursor;	
	}
	public boolean delete(String id)
	{
		boolean flag = false;
		if(id.equals("")||id==null){
			flag=false;
		}
		else{
			
		String sql ="delete from goods where _id="+id;
		try{
			
			db.execSQL(sql);
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
		return flag;
	}
	
	public void delete()
	{
		db.execSQL("delete from goods");
	}
	}
