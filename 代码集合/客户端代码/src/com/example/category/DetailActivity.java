package com.example.category;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dbh.Handle;
import com.example.adapter.yiyego.cache.CacheFile;
import com.example.flower.R;


public class DetailActivity extends Activity {

	private TextView price, introduce;
	private ImageView image;
	private ImageView yes;
	//private CacheFile cachefile;
	private String imageurl, detail_goods_id, detail_name, detail_price,
			detail_introduce;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		price = (TextView) findViewById(R.id.price);
		introduce = (TextView) findViewById(R.id.introduce);
		image = (ImageView) findViewById(R.id.image);
		yes =  (ImageView) findViewById(R.id.yes);
		
		detail_name = b.getString("name");
		detail_introduce = b.getString("introduce");
		detail_price = b.getString("price");
		detail_goods_id = b.getString("goods_id");
		imageurl = b.getString("imageurl");
		price.setText(detail_price);
		
		System.out.println(imageurl);
	
		introduce.setText(detail_introduce);
		
		if((new CacheFile().getFile(imageurl))!=null)
		{
			System.out.println("yousdfaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		image.setImageBitmap(new CacheFile().getFile(imageurl));
		yes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Handle han = new Handle();
				han.dbopen();
				if (han.add(Integer.parseInt(detail_goods_id), detail_name,
						detail_price , imageurl)) {
					Toast.makeText(DetailActivity.this, "已加入购物车",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

	}
}
