package com.example.sendbroadcast;

import android.app.Activity;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

/*
 * ���ͱ�׼�㲥
 */


public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		Button button=(Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v){
				/*
				 * ʹ��Intent������Ҫ���͵Ĺ㲥
				 * Ȼ��ʹ��sendBroadCast���㲥���ͳ�ȥ
				 */
				Intent intent=new Intent("com.example.broadcasttest.MY_BROADCAST");
				sendBroadcast(intent);
			}
			
		});
		
		/*
		 * ��������㲥
		 */
		
		Button button2=(Button)findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("com.example.broadcasttest.MY_ORDEREDBROADCAST");
				sendOrderedBroadcast(intent,null);
			}
		});
		
	}

}
