package com.example.firstreceiver;

import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
 * ��̬ע��㲥
 * ��������SendBroadcast������㲥
 * 
 */

public class MyOrderBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Toast.makeText(context, "FirstMyOrderedBroadcast", Toast.LENGTH_LONG).show();

	}

}
