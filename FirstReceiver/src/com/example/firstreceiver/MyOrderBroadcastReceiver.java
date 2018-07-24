package com.example.firstreceiver;

import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
 * 静态注册广播
 * 接收来自SendBroadcast的有序广播
 * 
 */

public class MyOrderBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Toast.makeText(context, "FirstMyOrderedBroadcast", Toast.LENGTH_LONG).show();

	}

}
