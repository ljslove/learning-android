package com.example.firstreceiver;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/*
 * 改应用接收一个系统定义的android.intent.action.BOOT_COMPLETED（静态广播）
 * 接收来自于SendBroadcast应用的广播（动态广播）
 * 动态注册需要：广播接收器，一个intentfilter
 * 不需要在xml中注册了
 * 
 */

public class MainActivity extends Activity {
	
	private IntentFilter intentFilter;
	private MyBroadcastReceiver myBroadcastReceiver;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		intentFilter=new IntentFilter();
		intentFilter.addAction("com.example.broadcasttest.MY_BROADCAST");
		myBroadcastReceiver=new MyBroadcastReceiver();
		registerReceiver(myBroadcastReceiver,intentFilter);
		
		
	}
	@Override
	protected void onDestroy(){
		super.onDestroy();
		unregisterReceiver(myBroadcastReceiver);
	}
	
	/*
	 * 
	 * 动态广播
	 */
	class MyBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			Toast.makeText(context,"First BroadcastReceiver", Toast.LENGTH_LONG).show();

		}
	
	

}
	
}
