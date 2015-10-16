package com.example.person;

import com.example.flower.MainActivity;
import com.example.flower.R;
import com.example.flower.R.id;
import com.example.flower.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Update  extends Activity {
	
	private ImageView back;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);
		init();
	}
	private void init(){
		back = (ImageView) findViewById(R.id.button_back);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("page",3);
				intent.setClass(Update.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
