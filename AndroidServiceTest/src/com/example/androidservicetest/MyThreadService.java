package com.example.androidservicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyThreadService extends Service {
	
	
	@Override
	public void onCreate(){
		super.onCreate();
	}
	
	
	@Override
	public int onStartCommand(Intent intent,int flags,int startId){
		
		new Thread(new Runnable(){
			
			@Override
			public void run(){
				Log.d("MyThreadService","Thread id is "+Thread.currentThread().getId());
				stopSelf();
			}
			
		}).start();
		
		return super.onStartCommand(intent,flags,startId);
		
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
