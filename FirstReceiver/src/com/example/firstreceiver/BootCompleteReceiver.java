package com.example.firstreceiver;

import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
 * 静态注册实现开机启动
 * 重写父类的onReceive方法，当广播到来时，onReceive方法就会执行
 */

public class BootCompleteReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Boot complete", Toast.LENGTH_LONG).show();

	}

}
