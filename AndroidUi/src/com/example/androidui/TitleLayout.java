package com.example.androidui;

import com.example.androidui.R;

import android.widget.LinearLayout;
import android.widget.Toast;
import android.util.AttributeSet;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.app.Activity;

public class TitleLayout extends LinearLayout {
	
public TitleLayout(Context context,AttributeSet attrs){
		
		super(context,attrs);
		LayoutInflater.from(context).inflate(R.layout.title_layout,this);
		/*
		 * 在自定义的控件中，需要加上isInEditMode()，否则报错
		 * 
		 */
		if(isInEditMode()){
		return;
		}
		Button titleBack=(Button)findViewById(R.id.button_back);
		Button titleEdit=(Button)findViewById(R.id.button_edit);
		titleBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((Activity)getContext()).finish();
				
				
			}
		});
		titleEdit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getContext(), "You click Edit button", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		
	}

}
