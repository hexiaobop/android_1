package com.example.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.flower.BuycarFragment;
import com.example.flower.CategoryFragment;
import com.example.flower.HomeFragment;
import com.example.flower.MainActivity;
import com.example.flower.PersonFragment;


public class FragmentAdapter extends FragmentPagerAdapter{
	public final static int TAB_COUNT = 4;
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	
	public Fragment getItem(int id) {
		switch (id) {
		case MainActivity.TAB_HOME:
			HomeFragment homeFragment = new HomeFragment();
			return homeFragment;
		case MainActivity.TAB_CATAGORY:
			CategoryFragment categoryFragment = new CategoryFragment();
			return categoryFragment;
		case MainActivity.TAB_BUYCAR:
			BuycarFragment buycarFragment = new BuycarFragment();
			return buycarFragment;
		case MainActivity.TAB_PERSON:
			PersonFragment personFragment = new PersonFragment();
			return personFragment;
	
		}
		return null;
	}

	@Override
	public int getCount() {
		return TAB_COUNT;
	}
}
