package com.example.buycar;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dbh.Handle;
import com.example.adapter.yiyego.pojo.GoodsList;
import com.example.flower.MainActivity;
import com.example.flower.R;
import com.example.person.Book;
import com.google.gson.Gson;

public class Topay extends Activity implements OnClickListener {
	private TextView pay;
	private EditText address, phone;
	private ImageView sure;
	private boolean sendlistflag;
	String username;
	String goodslist;
	String price;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ordr_submit);
		pay = (TextView) findViewById(R.id.pay);
		address = (EditText) findViewById(R.id.editAddress);
		phone = (EditText) findViewById(R.id.editPhone);
		sure = (ImageView) findViewById(R.id.continue_shoping_text);
		sure.setOnClickListener(this);
		Intent intent = getIntent();
		username = intent.getStringExtra("username");
		goodslist = intent.getStringExtra("goodslist");
		price = intent.getStringExtra("price");
		pay.setText(price);
		init();

	}

	private void init() {

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String addre = address.getText().toString().trim();
		String ph = phone.getText().toString().trim();

		if (addre.equals("") || ph.equals("")) {
			Toast.makeText(Topay.this, "确认所填信息不为空", Toast.LENGTH_SHORT).show();
		} else {
			GoodsList goodorder = new GoodsList();
			goodorder.setAddress(addre);
			goodorder.setPhone(ph);
			goodorder.setMoney(price);
			goodorder.setUser_name(username);
			goodorder.setGoods_id(goodslist);
			Gson gson = new Gson();
			String sendlist = gson.toJson(goodorder);
			new SendList().execute(sendlist);

		}

	}

	class SendList extends AsyncTask<String,Void, Void> {

		@Override
		protected Void doInBackground(String... params) {
			
				String url = "http://10.13.53.130/1130huadian/list/accept";
				HttpPost post = new HttpPost(url);
				List<NameValuePair> paramss = new ArrayList<NameValuePair>();
				paramss.add(new BasicNameValuePair("sendlist",params[0]));
				
			
					try {
						post.setEntity(new UrlEncodedFormEntity(paramss, HTTP.UTF_8));
						HttpClient client = new DefaultHttpClient();
						HttpResponse response = client.execute(post);							
						if(response.getStatusLine().getStatusCode() == 200)
						{
							String x = EntityUtils.toString(response.getEntity());
							if(x.equals("ok")){
								sendlistflag = true;
								
							}
							else
							{
								sendlistflag = false;
							}
						}
						else
						{
							sendlistflag = false;
						
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
					return null;
			
			
			// TODO Auto-generated method stub
			
		}

		@Override
		//如果订单提交成功则清空购物车
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			if(sendlistflag)
			{
				Toast.makeText(Topay.this, "订单已提交!", Toast.LENGTH_SHORT).show();
				Handle han = new Handle();
				han.dbopen();
				han.delete();
				Intent intent = new Intent();
				intent.putExtra("page", 3);
				intent.setClass(Topay.this, 
						MainActivity.class);
				startActivity(intent);
			}
			else
			{
				
			}
		}
		
	}

}
