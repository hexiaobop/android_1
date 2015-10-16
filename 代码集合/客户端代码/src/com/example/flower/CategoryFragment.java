package com.example.flower;

import com.example.category.CategoryOne;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

public class CategoryFragment extends Fragment implements OnClickListener {
	private ImageView list1;
	private ImageView list2;
	private ImageView list3;
	private ImageView list4;
	private ImageView list5;
	private ImageView list6;
	private ImageView search;
	private EditText searcht;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.category, container, false);
		init(view);
		return view;
	}

	private void init(View v) {
		list1 = (ImageView) v.findViewById(R.id.button_list1);
		list2 = (ImageView) v.findViewById(R.id.button_list2);
		list3 = (ImageView) v.findViewById(R.id.button_list3);
		list4 = (ImageView) v.findViewById(R.id.button_list4);
		list5 = (ImageView) v.findViewById(R.id.button_list5);
		list6 = (ImageView) v.findViewById(R.id.button_list6);
		search = (ImageView) v.findViewById(R.id.search_btn);
		searcht = (EditText) v.findViewById(R.id.search_edit);
 		list1.setOnClickListener(this);
		list2.setOnClickListener(this);
		list4.setOnClickListener(this);
		list3.setOnClickListener(this);
		list5.setOnClickListener(this);
		list6.setOnClickListener(this);
		search.setOnClickListener(this);
	}

	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.button_list1: {
			// TODO Auto-generated method stub
			intent.putExtra("cate", 1);
			break;
		}
		case R.id.button_list2: {
			intent.putExtra("cate", 2);
			break;
		}
		case R.id.button_list3: {
			intent.putExtra("cate", 3);
			break;
		}
		case R.id.button_list4: {
			intent.putExtra("cate", 4);
			break;
		}
		case R.id.button_list5: {
			intent.putExtra("cate", 5);
			break;
		}
		case R.id.button_list6: {
			intent.putExtra("cate", 6);
			break;
		}
		case R.id.search_btn: {
			String x = searcht.getText().toString().trim();
			if(x.equals(""))
				x = "ÇéÈË½Ú";
			intent.putExtra("cate", 7);
			intent.putExtra("searchID", x);
			break;
		}
		default:
			break;
		}
		intent.setClass(getActivity(), CategoryOne.class);
		startActivity(intent);
	}

}
