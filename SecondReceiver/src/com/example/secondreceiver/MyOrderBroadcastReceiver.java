package com.example.secondreceiver;

import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
 * ��̬�㲥����������SendBroadcast������㲥
 * �ȼ��ϵ�
 * ������Ϲ㲥
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
