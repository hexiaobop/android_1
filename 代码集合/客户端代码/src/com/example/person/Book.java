package com.example.person;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.adapter.yiyego.pojo.Goods;
import com.example.flower.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Book  extends Activity {
	private ListView list;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_order);
		list = (ListView) findViewById(R.id.listView1);	
		SharedPreferences userdate = this.getSharedPreferences(
				"USER", 0);
		String x = userdate.getString("name", "");	
		if(x.equals(""))
		{
			Toast.makeText(Book.this, "Î´µÇÂ½", Toast.LENGTH_SHORT).show();
		}
		 else
		{
			
			new MyAsnu().execute(x);
		}
	}
	class MyAsnu extends AsyncTask<String, Void, List<Map<String,String>>>
	{

		@Override
		protected List<Map<String, String>> doInBackground(String... params) {
			// TODO Auto-generated method stub
			List<Map<String,String>> list = null;
		
			String url = "http://10.13.53.130/1130huadian/list/send";
			HttpPost post = new HttpPost(url);
			List<NameValuePair> paramss = new ArrayList<NameValuePair>();
			paramss.add(new BasicNameValuePair("name", params[0]));			
			try {
				post.setEntity(new UrlEncodedFormEntity(paramss, HTTP.UTF_8));
				HttpClient client = new DefaultHttpClient();
				HttpResponse response = client.execute(post);
				if (response.getStatusLine().getStatusCode() == 200) {
					String x = EntityUtils.toString(response.getEntity());
					Gson gson = new Gson();
					list =	gson.fromJson(x, new TypeToken<List<Map<String,String>>>(){}.getType());
				
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}

		@Override
		protected void onPostExecute(List<Map<String, String>> result) {
			// TODO Auto-generated method stub
			System.out.println(result);
			SimpleAdapter adapter = new SimpleAdapter(Book.this, result, R.layout.order_detail, new String[]{"happentime","number","money"},new int[]{R.id.time,R.id.number,R.id.price});
			list.setAdapter(adapter);
			super.onPostExecute(result);
		}
		
		
	}

	

	
}	
	
