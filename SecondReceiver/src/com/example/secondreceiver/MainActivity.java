package com.example.secondreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

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
	
	class MyBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			Toast.makeText(context,"Second Broadcast Receiver",Toast.LENGTH_LONG).show();

		}
	

}
}
