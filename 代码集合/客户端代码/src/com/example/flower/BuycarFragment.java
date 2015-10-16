package com.example.flower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dbh.Handle;
import com.example.buycar.BuycarAdapter;
import com.example.buycar.Topay;
import com.example.person.Login;

public class BuycarFragment extends Fragment {
	private ListView listview;
	private TextView count;
	private BuycarAdapter buycar;
	private Button topay;
	private boolean topayflag;
	private String now_user;
	int paymoneny = 0;
	private ImageView empty;
	Handle handle = new Handle();

	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	Cursor cursor;
	View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		paymoneny = 0;
		list.clear();
		handle.dbopen();
		cursor = handle.findall();
		if ((cursor.getCount() == 0) || cursor == null) {
			v = inflater.inflate(R.layout.buycar, container, false);
			empty = (ImageView) v.findViewById(R.id.settle_accounts);
			empty.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.putExtra("page", 1);
					intent.setClass(getActivity(),MainActivity.class );
					startActivity(intent);
				}
			});
			
		} else {

			v = inflater.inflate(R.layout.buycar_ready, container, false);
			count = (TextView) v.findViewById(R.id.textView1);
			topay = (Button) v.findViewById(R.id.jiesuan);
			topay.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					SharedPreferences userdate = getActivity()
							.getSharedPreferences("USER", 0);
					now_user = (userdate.getString("name", ""));
					if (now_user.equals("")) {

						Intent intent = new Intent();
						intent.setClass(getActivity(), Login.class);
						startActivity(intent);
					} else {
						String jk = "";
						Intent intent = new Intent();
						intent.putExtra("price", String.valueOf(paymoneny));
						for (Map<String, String> i : list) {
							jk += "" + i.get("goods_id") + "#";
						}
						intent.putExtra("username", now_user);
						intent.putExtra("goodslist", jk);
						intent.setClass(getActivity(), Topay.class);
						startActivity(intent);
					}
				}
			});

			listview = (ListView) v.findViewById(R.id.buycarlist);
			while (cursor.moveToNext()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("_id", cursor.getString(cursor.getColumnIndex("_id")));
				map.put("name",
						cursor.getString(cursor.getColumnIndex("goods_name")));

				map.put("price",
						cursor.getString(cursor.getColumnIndex("goods_price")));

				map.put("goods_id",
						cursor.getString(cursor.getColumnIndex("goods_id")));

				map.put("imageurl", cursor.getString(cursor
						.getColumnIndex("goods_imageurl")));
				paymoneny += Integer.parseInt(cursor.getString(cursor
						.getColumnIndex("goods_price")));
				list.add(map);
			}
			buycar = new BuycarAdapter(getActivity(), list);
			count.setText("£¤" + paymoneny + ".00");
			System.out.println(listview);
			listview.setAdapter(buycar);

			listview.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// v.findViewById(R.id.)
					TextView text = (TextView) arg1.findViewById(R.id._id);
					TextView text1 = (TextView) arg1.findViewById(R.id.price);
					String price = text1.getText().toString();
					String index = (String) text.getText();
					if (handle.delete(String.valueOf(index))) {
						Toast.makeText(getActivity(), "É¾³ý", Toast.LENGTH_SHORT)
								.show();
					}
					list.remove(arg2);
					paymoneny = paymoneny
							- Integer.parseInt(price.replace("£¤", "").replace(
									".00", ""));
					buycar.notifyDataSetChanged();
					count.setText("£¤" + paymoneny + ".00");
					return false;
				}
			});
			// listview.clear();
			// listview.notifyDataSetChanged();
		}
		return v;

	}

}
