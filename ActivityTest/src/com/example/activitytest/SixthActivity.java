package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SixthActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sixth_layout);
		Button button7=(Button)findViewById(R.id.button_7);
		button7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.putExtra("data_return", "Hello FirstActivity");
				setResult(RESULT_OK,intent);
				finish();
			}
		});
		
	}

}
