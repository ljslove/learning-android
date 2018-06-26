package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import java.lang.String;
import android.util.Log;

public class SecondActivity extends Activity {
	
	public static final String TAG="SecondActivity";
	
	/*
	 * 重写onCreate()方法：
	 * 需要调用父类的onCreate()方法，适用super关键字来调用父类被覆盖的方法
	 * setContentView()方法将布局加载到活动中
	 */
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		Button button21=(Button)findViewById(R.id.button_21);
		button21.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(SecondActivity.this,NormalActivity.class);
				startActivity(intent);
			}
		});
		Button button22=(Button)findViewById(R.id.button_22);
		button22.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(SecondActivity.this,DialogActivity.class);
				startActivity(intent);
				
			}
		});
		
	}
	@Override
	public void onStart(){
		super.onStart();
		Log.d(TAG,"onStart");
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		Log.d(TAG,"onResume");
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		Log.d(TAG,"onPause");
	}
	
	@Override
	
	protected void onStop(){
		super.onStop();
		Log.d(TAG,"onStop");
	}
	
	@Override
	
	protected void onDestroy(){
		super.onDestroy();
		Log.d(TAG,"onDestory");
	}
	
	@Override
	
	protected void onRestart(){
		super.onRestart();
		Log.d(TAG,"onRestart");
	}
	
	
	

}
