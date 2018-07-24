package com.example.secondreceiver;

import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
 * 静态广播，接收来自SendBroadcast的有序广播
 * 等级较低
 * 并且阻断广播
 * 
 */

public class MyOrderBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context,"SecondMyOrderBroadcast", Toast.LENGTH_LONG).show();
		abortBroadcast();

	}

}
