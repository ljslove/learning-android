package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class FifithActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifith_layout);
		/*
		 * �������ݴ洢��intent�������Ҫ��ȡ��intent
		 * getIntent()���ڻ�ȡ���������û��intent
		 * Ȼ��Ӽ�ֵ����ȡ�ø�ֵ
		 */
		Intent intent=getIntent();
		String data=intent.getStringExtra("extra_data");
		Log.d("FifithActivity",data);
		
		/*
		 * ����һ�����������ʱ
		 * ���Ƚ����ݷ���Intent�У�Ȼ��ʹ��setResult()����������һ�����������
		 * 
		 */
		
		
		
	}

}
