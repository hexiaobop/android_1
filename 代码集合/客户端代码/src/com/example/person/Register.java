package com.example.person;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.example.flower.R;

public class Register extends Activity implements OnClickListener {
	private EditText write_username;
	private EditText write_password;
	private EditText rewrite_pw;
	private EditText write_phone;
	private ImageView button_register;
	private RadioGroup radio_sex;
	private String sex = "男";
	private RadioButton boy,girl;
	private String errornetwork;
	private boolean result;
	private Handler handle = new Handler();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_register);
		init();
	}

	private void init() {
		write_username = (EditText) findViewById(R.id.editText1);
		write_password = (EditText) findViewById(R.id.editText2);
		rewrite_pw = (EditText) findViewById(R.id.editText3);
		write_phone = (EditText) findViewById(R.id.editText4);
		button_register = (ImageView) findViewById(R.id.regist_regist);
		radio_sex = (RadioGroup) findViewById(R.id.radioGroup);
		boy = (RadioButton) findViewById(R.id.radioBoy);
		girl = (RadioButton) findViewById(R.id.radioGirl);
		button_register.setOnClickListener(this);
		write_password
				.setOnFocusChangeListener(Login.onFocusAutoClearHintListener);
		rewrite_pw.setOnFocusChangeListener(Login.onFocusAutoClearHintListener);
		write_phone
				.setOnFocusChangeListener(Login.onFocusAutoClearHintListener);
		write_username
				.setOnFocusChangeListener(Login.onFocusAutoClearHintListener);
	

		radio_sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if (checkedId == boy.getId())
					{sex = "男";}
		
				else if(checkedId == girl.getId())
					{sex = "女";}
			}
		});

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.regist_regist){
			for(int i =0;i<10;i++){System.out.println("开始");}
		String input_username = write_username.getText().toString().trim();
		String input_password1 = write_password.getText().toString().trim();
		String input_password2 = rewrite_pw.getText().toString().trim();
		String input_phone = write_phone.getText().toString().trim();
		
		int flag = registeSuccess(input_password1, input_password2,
				input_username, input_phone);
	
			for(int i =0;i<10;i++){System.out.println(flag);}
		if (flag == 1)
			Toast.makeText(this, "内容键入不完整，请重新输入", Toast.LENGTH_LONG).show();
		else if (flag == 2)
			Toast.makeText(this, "两次密码键入不一致，请重新输入", Toast.LENGTH_LONG).show();
		else if (flag == 3)
			Toast.makeText(this, "手机号码键入有误，请重新输入", Toast.LENGTH_LONG).show();

		else if (flag == 200) {
			new Thread(new RegisterThread(input_username, input_password1, input_phone, sex)).start();
			

		}
		}
	}

	private int registeSuccess(String input_password1, String input_password2,
			String input_username, String input_phone) {
		int flag = 100;
		String Mobile_regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}";

		if ((input_password1.equals("") || input_password2.equals("")
				|| input_username.equals("") || input_phone.equals(""))) {
			flag = 1;
		} else if (!input_password1.equals(input_password2)) {
			flag = 2;
		} 
//			else if (!input_phone.matches(Mobile_regex)) {
//			flag = 3;
//		}

		else {
			flag = 200;
		}
		return flag;

	}

	// private HttpClient getHttpClient() {
	// // TODO Auto-generated method stub
	// BasicHttpParams httpParams = new BasicHttpParams();
	// HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
	// HttpConnectionParams.setSoTimeout(httpParams, 5000);
	// HttpClient client = new DefaultHttpClient(httpParams);
	// return client;
	// }

	private boolean sqlIsOk(String un, String pw, String ph, String sex) {
		boolean result = false;
		String url = "http://10.13.53.130/1130huadian/user/register";
		HttpPost post = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", un));
		params.add(new BasicNameValuePair("password", pw));
		params.add(new BasicNameValuePair("phone", ph));
		params.add(new BasicNameValuePair("sex", sex));
		try {
			post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				String x = EntityUtils.toString(response.getEntity());
				if (x.equals("success")) {
					
					errornetwork = "注册成功";
					result = true;
				} else {
					errornetwork = "用户已存在";
					result = false;
				}

			} else {
				errornetwork = "网络错误";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public class RegisterThread implements Runnable {
		String un,pw,ph,sex;
		boolean flag; 
		
		
		public RegisterThread(String un, String pw, String ph, String sex) {
			super();
			this.un = un;
			this.pw = pw;
			this.ph = ph;
			this.sex = sex;
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			for(int i=0;i<10;i++)
			{
				System.out.println(sex);
			}
			flag = sqlIsOk(un, pw, ph, sex);
			
			handle.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(flag)
					{
						Toast.makeText(Register.this, errornetwork, Toast.LENGTH_LONG).show();
					Intent intent = new Intent();
					intent.setClass(Register.this, Login.class);
					startActivity(intent);
					}
					else
					{
						Toast.makeText(Register.this, errornetwork, Toast.LENGTH_LONG).show();
					}
				}
			});
			
		}
	}
}
