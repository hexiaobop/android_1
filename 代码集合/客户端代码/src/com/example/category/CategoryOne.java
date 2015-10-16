package com.example.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dbh.Handle;
import com.example.adapter.yiyego.fromserver.JsonFromServer;
import com.example.adapter.yiyego.pojo.Goods;
import com.example.adapter.yiyegoo.myadapte.MyAdapter;
import com.example.flower.R;
import com.google.gson.JsonArray;

public class CategoryOne extends Activity {
	private ListView list;
	private int page = 1;
	private TextView title;
	private Handler handler = new Handler();
	private String choose;
	private int visible;

	List<Map<String, String>> adalist = new ArrayList<Map<String, String>>();
	private JsonArray jsonarray;
	private List<Goods> listgoods;
	private List<Map<String, String>> mymap;
	// private String url =
	// "http://10.13.53.154/1130huadian/goods?page="+String.valueOf(page);
	private String url;
	private Thread thread;
	private MyAdapter madape;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cate_list_someone);
		Handle handle = new Handle();
		handle.dbopen();
		handle.creattable();
		init();

	}

	private void init() {
		title = (TextView) findViewById(R.id.titleText1);
		list = (ListView) findViewById(R.id.goods_list);
		Intent intent = getIntent();
		choose = intent_back(intent);
		url = "http://10.13.53.130/1130huadian/goods?page="
				+ String.valueOf(page) + "&style_id=" + choose;
		start();
		list.setOnScrollListener(new OnScrollListener() {
			boolean isLastRow = false;
			private int lastVisibleItemPosition = 0;

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				if (isLastRow
						&& scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
					Toast.makeText(CategoryOne.this, "加载图片", Toast.LENGTH_SHORT)
							.show();
					start();
					isLastRow = false;
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				visible = visibleItemCount;
				if (firstVisibleItem > lastVisibleItemPosition) {
					if (firstVisibleItem + visibleItemCount == totalItemCount
							&& totalItemCount > 0)
						isLastRow = true;
					lastVisibleItemPosition = firstVisibleItem;
				}
			}
		});

		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				Bundle bund = new Bundle();
				bund.putString("name", mymap.get(arg2).get("name"));
				bund.putString("price", mymap.get(arg2).get("price"));
				bund.putString("introduce", mymap.get(arg2).get("introduce"));
				bund.putString("imageurl", mymap.get(arg2).get("imageurl"));
				bund.putString("goods_id", mymap.get(arg2).get("goods_id"));
				intent.putExtras(bund);
				intent.setClass(CategoryOne.this, DetailActivity.class);
				startActivity(intent);
			}
		});

	}

	private String intent_back(Intent i) {
		int id = i.getIntExtra("cate", 0);
		String choose = String.valueOf(id);
		switch (id) {
		case 1:
			title.setText("新品推荐");
			break;
		case 2:
			title.setText("宅配良品");
			break;
		case 3:
			title.setText("分类三");
			break;
		case 4:
			title.setText("分类四");
			break;
		case 5:
			title.setText("分类五");
			break;
		case 6:
			title.setText("分类六");
			break;
		case 7:
			String x = i.getStringExtra("searchID");
			title.setText("“" + x + "”的相关商品");
			break;
		}
		return choose;
	}

	public void start() {
		thread = new Thread(new GetDetail());
		thread.start();
		new MyAsyn().execute();
		return;
	}

	public class MyAsyn extends AsyncTask<Void, Integer, String> {
		@Override
		protected String doInBackground(Void... params) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
			return null;
		}

		// 这就相当于主线程，也就是是说可以开异步
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			if (madape == null) {
				madape = new MyAdapter(CategoryOne.this, mymap);
				list.setAdapter(madape);
			}

			madape.notifyDataSetChanged();
			list.setSelection(madape.getCount() - 6);
		}
	}

	/*
	 * //开启子线程 获取服务端数据并解析成想要的格式
	 */
	public class GetDetail implements Runnable {
		public void run() {
			String sss;
			try {
				sss = JsonFromServer.jsonarray(url);

				listgoods = JsonFromServer.jsonarraytocollection(sss);

				for (Goods g : listgoods) {
					Map<String, String> map = new HashMap<String, String>();
					System.out
							.println("---------------------------------------------");
					map.put("name", g.getName());
					map.put("price", String.valueOf(g.getPrice()));
					map.put("imageurl", g.getImageurl());
					map.put("introduce", g.getIntroduce());
					map.put("goods_id", String.valueOf(g.getGoods_id()));
					System.out
							.println("---------------------------------------------");
					System.out.println(listgoods.size());
					adalist.add(map);
				}
				mymap = adalist;
				page = page + 1;
				if (page > 21) {
					page = 1;
				}
				url = "http://10.13.53.130/1130huadian/goods?page="
						+ String.valueOf(page) + "&style_id=" + choose;
			}

			catch (Exception e) {
				handler.post(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Toast.makeText(CategoryOne.this, "网络未连接",
								Toast.LENGTH_LONG).show();
					}
				});
			}
		}
	}
}