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
	 * onCreate�����ڴ�������ʱ����
	 */
	@Override
	public void onCreate(){
		super.onCreate();
		Log.d("MyBinderService","onCreate executed");
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
	 * onStartCommand������ÿ����������ʱ���á��������ϣ������һ������������ִ��ĳ�����������ǾͿ��Խ��߼�д������
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
	 * ���ٷ���ʱ����
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
	 * ��дһ�������̳�Binder�ࡣ������ĸ��ַ����������ڻ���κεط�����
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
