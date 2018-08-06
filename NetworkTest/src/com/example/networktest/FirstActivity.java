package com.example.networktest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class FirstActivity extends Activity implements View.OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_layout);
		Button webButton=(Button)findViewById(R.id.webview);
		Button xmlpullButton=(Button)findViewById(R.id.xmlpull);
		Button xmlsaxButton=(Button)findViewById(R.id.xmlsax);
		Button jsonButton=(Button)findViewById(R.id.json);
		webButton.setOnClickListener(this);
		xmlpullButton.setOnClickListener(this);
		xmlsaxButton.setOnClickListener(this);
		jsonButton.setOnClickListener(this);
		
	}
	
	
	@Override
	public void onClick(View v){
		
		switch(v.getId()){
		case R.id.webview:
			Intent intent1=new Intent(FirstActivity.this,WebviewActivity.class);
			startActivity(intent1);
			break;
		case R.id.xmlpull:
			Intent intent2=new Intent(FirstActivity.this,XmlpullActivity.class);
			startActivity(intent2);
			break;
		case R.id.xmlsax:
			Intent intent3=new Intent(FirstActivity.this,XmlsaxActivity.class);
			startActivity(intent3);
			break;
		case R.id.json:
			Intent intent4=new Intent(FirstActivity.this,JsonActivity.class);
			startActivity(intent4);
			break;
			default:
				break;
			
		}
		
	}
	
	

}
