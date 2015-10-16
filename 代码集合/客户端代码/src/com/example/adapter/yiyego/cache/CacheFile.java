package com.example.adapter.yiyego.cache;
/**
 * 
 * @黑星
 * 图片缓存工具
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
 
public class CacheFile {
    private static final String DIR_NAME = "FlowerImageche";
    private File cacheDir;
 
    public CacheFile() {
        // Find the directory to save cached images
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            cacheDir = new File(
                    android.os.Environment.getExternalStorageDirectory(),
                    DIR_NAME);
        } else {
           
            ;
        }
 
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
    }
    //通过url获取到bitmap
    public Bitmap getFile(String url) {
        // Identify images by url's hash code
        String filename = String.valueOf(url = url.replaceAll("/",""));
 
        File f = new File(cacheDir, filename);
       return  decodeFile(f);
     
    }
   public Bitmap decodeFile(File f) {
        try {
            // TODO:Compress image size
            FileInputStream fileInputStream = new FileInputStream(f);
            Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
            return bitmap;
 
        } catch (FileNotFoundException e) {
            return null;
        }
    }
   
   public void saveMyBitmap(String url,Bitmap bitmap) throws IOException {  
	   url =url.replaceAll("/","");
	    File f = new File(cacheDir,url);  
	    if(f.exists())
	    {
	    	;
	    }
	    else{
	   
	    f.createNewFile();  
	    FileOutputStream fOut = null;  
	    try {  
	            fOut = new FileOutputStream(f);  
	    } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	    }  
	    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);  
	    try {  
	            fOut.flush();  
	    } catch (IOException e) {  
	            e.printStackTrace();  
	    }  
	    try {  
	            fOut.close();  
	    } catch (IOException e) {  
	            e.printStackTrace();  
	    }  
	    }
	}

    public void clear() {
        File[] files = cacheDir.listFiles();
        if (files == null) {
            return;
        } else {
            for (File f : files) {
                f.delete();
            }
        }
    }
}