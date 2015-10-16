package com.example.flower;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class HomeFragment extends Fragment {

	private Gallery mGallery;
	private boolean mOnTouch;
	View view;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("HomeFragment");
		view = inflater.inflate(R.layout.home, container, false);

		mGallery = (Gallery) view.findViewById(R.id.gallery);
		ImageAdapter imageAdapter = new ImageAdapter(getActivity());
		mGallery.setAdapter(imageAdapter);
		mGallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position,
					long id) {

			}
		});
		mGallery.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v,MotionEvent event) {
                int action =event.getAction();
                if (action == MotionEvent.ACTION_DOWN) {
                    mOnTouch = true;
                }else if(action == MotionEvent.ACTION_UP) {
                    mOnTouch = false;
                }
                return false;
            }
        });
		startAutoScroll();
		return view;
		// return inflater.inflate(R.layout.home, container, false);
	}
	private void startAutoScroll() {
        new Thread() {
            @Override
            public void run() {
                int count = 0;  
                int mPosition = 0;
                while (true) {
                    count= 0;
                    //这段逻辑用于用户手动滑动时，停止自动滚动
                    while (count < 10) {
                        count++;
                        try {
                            Thread.sleep(150);
                        }catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (mOnTouch) {// 用戶手动滑动时，停止自动滚动
                            count= 0;
                           mPosition=3;
                        }
                    }   
                    mPosition++;
                    Message msg = mHandler.obtainMessage(0, mPosition, 0);
                    mHandler.sendMessage(msg);
                }
            }
        }.start();
    }
	private Handler mHandler= new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case 0:
                mGallery.setSelection(msg.arg1);//进行图片切换
                break;
            }
        }
    };

	private class ImageAdapter extends BaseAdapter {
		private Context mContext;
		private Integer[] mImage = { R.drawable.gallery1, R.drawable.gallery2,
				R.drawable.gallery3,

		};

		public ImageAdapter(Context c) {
			mContext = c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub

			return Integer.MAX_VALUE;// 用于循环滚动

		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub

			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub

			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			position=  position % 3;
			ImageView i = new ImageView(mContext);
			i.setImageResource(mImage[position]);
			i.setScaleType(ImageView.ScaleType.FIT_XY);
			i.setLayoutParams(new Gallery.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

			return i;
		}

	};
}