package com.example.androidservicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Service#onCreate()
	 * onCreate�����ڴ�������ʱ����
	 */
	@Override
	public void onCreate(){
		super.onCreate();
		Log.d("MyService","onCreate executed");
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
	 * onStartCommand������ÿ����������ʱ���á��������ϣ������һ������������ִ��ĳ�����������ǾͿ��Խ��߼�д������
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
	 * ���ٷ���ʱ����
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
	 * Service�е�Ψһ��һ�����󷽷���������д
	 */

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
