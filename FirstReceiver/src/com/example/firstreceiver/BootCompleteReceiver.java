package com.example.firstreceiver;

import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
 * ��̬ע��ʵ�ֿ�������
 * ��д�����onReceive���������㲥����ʱ��onReceive�����ͻ�ִ��
 */

public class BootCompleteReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Boot complete", Toast.LENGTH_LONG).show();

	}

}
