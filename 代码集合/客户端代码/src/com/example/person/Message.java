package com.example.person;

import com.example.flower.MainActivity;
import com.example.flower.R;
import com.example.flower.R.id;
import com.example.flower.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Message  extends Activity {
	
	private ImageView back;
	private ImageView logout;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message);
		init();
	}
	private void init(){
		back = (ImageView) findViewById(R.id.button_back);
		logout = (ImageView) findViewById(R.id.logout);
		logout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences userdate = getSharedPreferences("USER", 0);
				SharedPreferences.Editor editor = userdate.edit();
				editor.putString("name", "");
				editor.commit();
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("page",3);
				intent.setClass(Message.this, MainActivity.class);
				startActivity(intent);
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("page",3);
				intent.setClass(Message.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
