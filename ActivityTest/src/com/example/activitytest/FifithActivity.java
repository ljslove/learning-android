package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class FifithActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifith_layout);
		/*
		 * 由于数据存储在intent里，所以先要获取到intent
		 * getIntent()用于获取用于启动该活动的intent
		 * 然后从键值对中取得该值
		 */
		Intent intent=getIntent();
		String data=intent.getStringExtra("extra_data");
		Log.d("FifithActivity",data);
		
		/*
		 * 向上一个活动返回数据时
		 * 首先将数据放在Intent中，然后使用setResult()方法，向上一个活动返回数据
		 * 
		 */
		
		
		
	}

}
