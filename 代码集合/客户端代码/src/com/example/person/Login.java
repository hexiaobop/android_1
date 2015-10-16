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

import com.example.flower.MainActivity;
import com.example.flower.R;
import com.example.flower.R.id;
import com.example.flower.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {

	private EditText username_edit;
	private EditText password_edit;
	private ImageView login_button;
	private ImageView goto_register;
	private int result = 20;
	private Handler handler = new Handler();
	Thread thread;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_login);
		init();
	}

	private void init() {
		username_edit = (EditText) findViewById(R.id.edit_username);
		password_edit = (EditText) findViewById(R.id.edit_password);
		login_button = (ImageView) findViewById(R.id.login_login);
		goto_register = (ImageView) findViewById(R.id.goto_register);
		login_button.setOnClickListener(this);
		goto_register.setOnClickListener(this);
		username_edit
				.setOnFocusChangeListener(Login.onFocusAutoClearHintListener);
		password_edit
				.setOnFocusChangeListener(Login.onFocusAutoClearHintListener);

	}
		//监听函数
	public void onClick(View v) {
		if (v.getId() == R.id.login_login) {
			String un = username_edit.getText().toString();
			String pw = password_edit.getText().toString();
			isnull(un, pw);

			if (result == 1) {
				Toast.makeText(this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();

			} else if (result == 200) {
				new Thread(new MyLogin(un, pw)).start();

			}

		}

		if (v.getId() == R.id.goto_register) {
			Intent intent = new Intent();
			intent.setClass(Login.this, Register.class);
			startActivity(intent);

		}

	}
	//向服务器发送数据的方法
	private void sqlIsOk(String un, String pw) {

		String url = "http://10.13.53.130/1130huadian/user/login";
		HttpPost post = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", un));
		params.add(new BasicNameValuePair("password", pw));
		try {
			post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(post);
			for (int i = 0; i < 10; i++) {
				System.out.println("信息发了的");
			}
			if (response.getStatusLine().getStatusCode() == 200) {
				String x = EntityUtils.toString(response.getEntity());
				for (int i = 0; i < 10; i++) {
					System.out.println(x);
				}
				if (x.equals("successboy"))
					result = 0;

				else if (x.equals("successgirl"))
					result = 10;
				else if (x.equals("fail"))
					result = 3;
			} else {
				result = 100;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//判断文本框是否为空
	public void isnull(String un, String pw) {
		if ((un.equals("")) || pw.equals("")) {

			result = 1;
		} else if (((!un.equals(""))) && (!un.equals(""))) {
			result = 200;
		}

	}

	// private HttpClient getHttpClient() {
	// // TODO Auto-generated method stub
	// BasicHttpParams httpParams = new BasicHttpParams();
	// HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
	// HttpConnectionParams.setSoTimeout(httpParams, 5000);
	// HttpClient client = new DefaultHttpClient(httpParams);
	// return client;
	// }
	public static OnFocusChangeListener onFocusAutoClearHintListener = new OnFocusChangeListener() {
		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			EditText textView = (EditText) v;
			String hint;
			if (hasFocus) {
				hint = textView.getHint().toString();
				textView.setTag(hint);
				textView.setHint("");
			} else {
				hint = textView.getTag().toString();
				textView.setHint(hint);
			}
		}
	};
//获取数据的线程
	class MyLogin implements Runnable {

		String un, pw;

		MyLogin(String un, String pw) {
			this.un = un;
			this.pw = pw;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			sqlIsOk(un, pw);

			handler.post(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					switch (result) {
					case 0: {
						boolean sex = true;
						SharedPreferences userdate = getSharedPreferences(
								"USER", 0);
						SharedPreferences.Editor editor = userdate.edit();
						editor.putString("name", username_edit.getText()
								.toString().trim());
						editor.putBoolean("sex_boy", sex);
						editor.commit();
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						intent.putExtra("page", 3);
						intent.setClass(Login.this, MainActivity.class);
						startActivity(intent);
						break;
					}
					case 10: {
						boolean sex = false;
						SharedPreferences userdate = getSharedPreferences(
								"USER", 0);
						SharedPreferences.Editor editor = userdate.edit();
						editor.putString("name", username_edit.getText()
								.toString().trim());
						editor.putBoolean("sex_boy", sex);
						editor.commit();
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						intent.putExtra("page", 3);
						intent.setClass(Login.this, MainActivity.class);
						startActivity(intent);
						break;
					}
					}
				}
			});

		}

	}

}
