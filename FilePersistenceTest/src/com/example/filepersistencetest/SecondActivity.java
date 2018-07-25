package com.example.filepersistencetest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.preference.*;
import android.content.IntentFilter;

public class SecondActivity extends Activity {
	
	private EditText account;
	private EditText psd;
	private CheckBox checkBox;
	private SharedPreferences pre;
	private SharedPreferences.Editor editor;
	private SaveBroadcastReceiver receiver;
	private IntentFilter intentFilter;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		Button login=(Button)findViewById(R.id.login);
		intentFilter=new IntentFilter();
		intentFilter.addAction("com.example.fileperfersistencetest.MY_BORADCAST");
		receiver=new SaveBroadcastReceiver();
		registerReceiver(receiver,intentFilter);
		account=(EditText)findViewById(R.id.account);
		psd=(EditText)findViewById(R.id.psd);
		checkBox=(CheckBox)findViewById(R.id.remember_pass);
		pre=PreferenceManager.getDefaultSharedPreferences(this);
		Boolean isRemember=pre.getBoolean("remember_password", false);
		if(isRemember){
			String myaccount=pre.getString("account","");
			String password=pre.getString("password","");
			account.setText(myaccount);
			psd.setText(password);
			checkBox.setChecked(true);
			
		}
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name=account.getText().toString();
				String psdword=psd.getText().toString();
				editor=pre.edit();
		
				if(name.equals("admin")&&psdword.equals("123456")){
				    if(checkBox.isChecked()){	
				editor.putString("account",name);
				editor.putString("password", psdword);
				editor.putBoolean("remember_password",true);
				}
				    else{
				    	editor.clear();
				    }
				editor.apply();
				Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
				
			    }else{
			      Toast.makeText(SecondActivity.this,"Account or Password is wrong", Toast.LENGTH_LONG).show();
			    }
			}
		});
		
		
		
		
		
		
		
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		unregisterReceiver(receiver);
	}
	class SaveBroadcastReceiver extends BroadcastReceiver{
		
		@Override
		public void onReceive(Context context,Intent intent){
			Intent intent1=new Intent(context,SecondActivity.class);
			context.startActivity(intent1);
			
			
		}
		
	}
	
	
	
	
	
	
	
	

}
