package com.example.firstreceiver;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/*
 * ��Ӧ�ý���һ��ϵͳ�����android.intent.action.BOOT_COMPLETED����̬�㲥��
 * ����������SendBroadcastӦ�õĹ㲥����̬�㲥��
 * ��̬ע����Ҫ���㲥��������һ��intentfilter
 * ����Ҫ��xml��ע����
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
	 * ��̬�㲥
	 */
	class MyBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			Toast.makeText(context,"First BroadcastReceiver", Toast.LENGTH_LONG).show();

		}
	
	

}
	
}
