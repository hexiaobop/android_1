package com.example.flower;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bean.User;
import com.example.person.Book;
import com.example.person.Login;
import com.example.person.Message;
import com.example.person.Update;

public class PersonFragment extends Fragment implements OnClickListener {
	private ImageView image_login;
	private RelativeLayout lay;
	private ImageView image_boy;
	private ImageView image_girl;
	private ImageView button_message;
	private ImageView button_book;
	private ImageView button_update;
	private TextView now_username;
	private User now_user = new User();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.person, container, false);
		init(v);
		return v;

	}

	private void init(View v) {
		{
			SharedPreferences userdate = getActivity().getSharedPreferences(
					"USER", 0);
			now_user.setUserName(userdate.getString("name", ""));
			now_user.setSex_boy(userdate.getBoolean("sex_boy", false));
		}
		image_login = (ImageView) v.findViewById(R.id.button1);
		image_boy = (ImageView) v.findViewById(R.id.boy_img);
		image_girl = (ImageView) v.findViewById(R.id.girl_img);
		button_message = (ImageView) v.findViewById(R.id.button2);
		button_book = (ImageView) v.findViewById(R.id.button3);
		button_update = (ImageView) v.findViewById(R.id.button4);
		now_username = (TextView) v.findViewById(R.id.now_username);
		lay = (RelativeLayout) v.findViewById(R.id.person_background);
		if (!now_user.getUserName().equals("")) {
			now_username.setText(now_user.getUserName());
			image_login.setVisibility(View.INVISIBLE);
			lay.setBackgroundResource(R.drawable.person_bg_user);		
			if (now_user.isSex_boy() == true)
				image_boy.setVisibility(View.VISIBLE);
			else
				image_girl.setVisibility(View.VISIBLE);

		}

		image_login.setOnClickListener(this);
		button_message.setOnClickListener(this);
		button_book.setOnClickListener(this);
		button_update.setOnClickListener(this);

	}

	public void onActivityCreated() {

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1: {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(getActivity(), Login.class);
			startActivity(intent);
			break;
		}
		case R.id.button2: {
			if(now_user.getUserName().equals("")){
				Intent intent = new Intent();
				intent.setClass(getActivity(), Login.class);
				startActivity(intent);
			}
			else
			{
			Intent intent = new Intent();
			intent.setClass(getActivity(), Message.class);
			startActivity(intent);
			}
			break;
		}
		case R.id.button3: {
			if(now_user.getUserName().equals("")){
				Intent intent = new Intent();
				intent.setClass(getActivity(), Login.class);
				startActivity(intent);
			}
			else{
			Intent intent = new Intent();
			intent.setClass(getActivity(), Book.class);
			startActivity(intent);
			}
			break;
		}
		case R.id.button4: {
			Intent intent = new Intent();
			intent.setClass(getActivity(), Update.class);
			startActivity(intent);
			break;
		}
		default:
			break;
		}
	}

}
