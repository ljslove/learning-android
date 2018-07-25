package com.example.filepersistencetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class ThirdActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third_layout);
		Button sendBroadcast=(Button)findViewById(R.id.broadcast);
		sendBroadcast.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent("com.example.fileperfersistencetest.MY_BORADCAST");
				sendBroadcast(intent);			
				
				
			}
		});
		
		
	}

}
