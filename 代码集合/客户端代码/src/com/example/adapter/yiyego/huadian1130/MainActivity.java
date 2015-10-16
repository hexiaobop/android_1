//package com.example.adapter.yiyego.huadian1130;
//
///**
// * 
// * @黑星
// */
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import android.app.Activity;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.widget.AbsListView;
//import android.widget.AbsListView.OnScrollListener;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.example.adapter.yiyego.fromserver.JsonFromServer;
//import com.example.adapter.yiyego.pojo.Goods;
//import com.example.adapter.yiyegoo.myadapte.MyAdapter;
//import com.example.flower.R;
//import com.google.gson.JsonArray;
//
//
//public class MainActivity extends Activity {
//	private Button btn;
//	private ListView list;
//	private int page=1;
//	
//	List<Map<String,String>> adalist = new ArrayList<Map<String,String>>(); 
//	private JsonArray jsonarray;
//	private List<Goods> listgoods;
//	private List<Map<String, String>> mymap;
//	private String url = "http://10.13.53.154/1130huadian/goods?page="+String.valueOf(page);
//	private Thread thread;
//	private MyAdapter madape ;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		btn  = (Button) findViewById(R.id.button1);
//		list = (ListView) findViewById(R.id.goods_list);		
//		thread = new Thread(new GetDetail());	
//		thread.start();
//		
//		
//		
//		list.setOnScrollListener(new OnScrollListener() {
//			boolean isLastRow = false;
//			@Override
//			public void onScrollStateChanged(AbsListView view, int scrollState) {
//				// TODO Auto-generated method stub
//				if(isLastRow && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE)
//				{
//					Toast.makeText(MainActivity.this, "加载图片", Toast.LENGTH_SHORT).show();
//					new Thread(new GetDetail()).start(); 
//					
//					new MyAsyn().execute();
//					
//					isLastRow =false;
//				}
//				else{
//					;
//				}
//				
//			}
//			
//			@Override
//			public void onScroll(AbsListView view, int firstVisibleItem,
//					int visibleItemCount, int totalItemCount) {
//				// TODO Auto-generated method stub
//				 if (firstVisibleItem + visibleItemCount == totalItemCount&& totalItemCount > 0)
//				 {
//					 isLastRow = true;
//					
//				 }								
//			}			
//		});			
//	}
//	//获取商品信息
//	public class MyAsyn extends AsyncTask<Void, Integer, String>  
//	{
//		@Override
//		protected String doInBackground(Void... params) {
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				for(int i=0;i<10;i++)
//				{					
//				System.out.println("出错了出错了出错了出错了出错了出错了出错了出错了出错了出错了");
//				}
//				e.printStackTrace();
//			}
//			for(int i=0;i<10;i++)
//			{
//				System.out.println("成功了成功了成功了成功了成功了成功了成功了成功了成功了成功了");
//			}			
//			return null;						
//			}
//		
//		//这就相当于主线程，也就是是说可以开异步
//		@Override		
//		protected void onPostExecute(String result) {
//			// TODO Auto-generated method stub
//			
//			madape= new MyAdapter(MainActivity.this, mymap);
//		
//			
//			 list.deferNotifyDataSetChanged();
//				list.setAdapter(madape);
//		}				
//	}	
//	
//	//开启子线程 获取服务端数据并解析成想要的格式
//	public class GetDetail implements Runnable {		
//		public void run() {
//			String sss;
//			sss = JsonFromServer.jsonarray(url);
//			listgoods = JsonFromServer.jsonarraytocollection(sss);
//			
//			for (Goods g :listgoods)
//			{
//				Map<String,String> map = new HashMap<String, String>();
//				System.out.println("---------------------------------------------");				
//				map.put("name", g.getName());		
//				map.put("price", String.valueOf(g.getPrice()));		
//				map.put("imageurl", g.getImageurl());
//				System.out.println("---------------------------------------------");
//				System.out.println(listgoods.size());
//				adalist.add(map);
//			}				
//			mymap =  adalist;
//			page = page +1;
//			if(page>21)
//			{
//				page=1;
//			}
//			url = "http://10.13.53.154/1130huadian/goods?page="+String.valueOf(page);
//		}
//
//	
//	
//	
//					
//	}
//	
//	}
//
