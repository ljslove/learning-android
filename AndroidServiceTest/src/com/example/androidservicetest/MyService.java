package com.example.androidservicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Service#onCreate()
	 * onCreate方法在创建服务时调用
	 */
	@Override
	public void onCreate(){
		super.onCreate();
		Log.d("MyService","onCreate executed");
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
	 * onStartCommand方法在每次启动服务时调用。如果我们希望服务一旦启动就立刻执行某个动作，我们就可以将逻辑写在这里
	 * 
	 */
	
	@Override
	public int onStartCommand(Intent intent,int flags,int startId){
		
		Log.d("MyService","onStartCommand executed");
		return super.onStartCommand(intent,flags,startId);
		
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Service#onDestroy()
	 * 销毁服务时调用
	 */
	
	@Override
	public void onDestroy(){
		
		super.onDestroy();
		Log.d("MyService","onDestroy executed");
		
	}
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 * Service中的唯一的一个抽象方法，必须重写
	 */

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
