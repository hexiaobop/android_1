package com.example.adapter.yiyego.image;
/**
 * 
 * @黑星
 * 获取图片的工具
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class StreamTool {
	
	//传入url返回图片
	public static Bitmap returnBitmap(String url) {
	    URL fileUrl = null;
	    Bitmap bitmap = null;	 
	    try {
	        fileUrl = new URL(url);
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }	 
	    try {
	        HttpURLConnection conn = (HttpURLConnection) fileUrl
	                .openConnection();
	        conn.setDoInput(true);
	        conn.connect();
	        InputStream is = conn.getInputStream();
	        bitmap = BitmapFactory.decodeStream(is);
	        is.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return bitmap;
	}
}