package com.example.flower;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.example.Dbh.Handle;
import com.example.adapter.FragmentAdapter;

public class MainActivity extends FragmentActivity implements OnClickListener {
	public static final int TAB_HOME = 0;
	public static final int TAB_CATAGORY = 1;
	public static final int TAB_BUYCAR = 2;
	public static final int TAB_PERSON = 3;

	private ViewPager viewPager;
	private RadioButton main_tab_home, main_tab_catagory, main_tab_buycar,
			main_tab_person;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		Handle han = new Handle();
		han.dbopen();
		han.creattable();
		initView();
		addListener();
		Intent intent = getIntent();
		intent_back(intent);
	}

	private void intent_back(Intent i){
		int id = i.getIntExtra("page", 0);
		switch(id){
		case TAB_HOME:
			main_tab_home.setChecked(true);
			viewPager.setCurrentItem(TAB_HOME);
			break;
		case TAB_CATAGORY:
			main_tab_catagory.setChecked(true);
			viewPager.setCurrentItem(TAB_CATAGORY);
			break;
		case TAB_BUYCAR:
			main_tab_buycar.setChecked(true);
			viewPager.setCurrentItem(TAB_BUYCAR);
			break;
		case TAB_PERSON:
			main_tab_person.setChecked(true);
			viewPager.setCurrentItem(TAB_PERSON);
			break;

		default:
			break;
		}
	}
	
	
	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		main_tab_home = (RadioButton) findViewById(R.id.button_home);
		main_tab_catagory = (RadioButton) findViewById(R.id.button_category);
		main_tab_buycar = (RadioButton) findViewById(R.id.button_buycar);
		main_tab_person = (RadioButton) findViewById(R.id.button_person);

		main_tab_home.setOnClickListener(this);
		main_tab_catagory.setOnClickListener(this);
		main_tab_buycar.setOnClickListener(this);
		main_tab_person.setOnClickListener(this);

		FragmentAdapter adapter = new FragmentAdapter(
				getSupportFragmentManager());
		viewPager.setAdapter(adapter);
	}

	private void addListener() {
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int id) {
				switch (id) {
				case TAB_HOME:
					main_tab_home.setChecked(true);
					break;
				case TAB_CATAGORY:
					main_tab_catagory.setChecked(true);
					break;
				case TAB_BUYCAR:
					main_tab_buycar.setChecked(true);
					break;
				case TAB_PERSON:
					main_tab_person.setChecked(true);
					break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_home:
			viewPager.setCurrentItem(TAB_HOME);
			break;
		case R.id.button_category:
			viewPager.setCurrentItem(TAB_CATAGORY);
			break;
		case R.id.button_buycar:
			
			viewPager.setCurrentItem(TAB_BUYCAR);
			break;
		case R.id.button_person:
			viewPager.setCurrentItem(TAB_PERSON);
			break;

		default:
			break;
		}
	}

	
}
