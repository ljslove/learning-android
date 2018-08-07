package com.example.androidservicetest;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBinderService extends Service {
	
	private DownloadBinder mBinder=new DownloadBinder();
	
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Service#onCreate()
	 * onCreate方法在创建服务时调用
	 */
	@Override
	public void onCreate(){
		super.onCreate();
		Log.d("MyBinderService","onCreate executed");
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
	 * onStartCommand方法在每次启动服务时调用。如果我们希望服务一旦启动就立刻执行某个动作，我们就可以将逻辑写在这里
	 * 
	 */
	
	@Override
	public int onStartCommand(Intent intent,int flags,int startId){
		
		Log.d("MyBinderService","onStartCommand executed");
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
		Log.d("MyBinderService","onDestroy executed");
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	
	/*
	 * 编写一个类来继承Binder类。该类里的各种方法都可以在活动的任何地方调用
	 * 
	 */
	
	class DownloadBinder extends Binder{
		
		public void startDownload(){
			Log.d("MyBinderService","startDownload executed");
		}
		
		public int getProgress(){
			Log.d("MyBinderService","getProgress executed");
			return 0;
		}
		
	}


}
