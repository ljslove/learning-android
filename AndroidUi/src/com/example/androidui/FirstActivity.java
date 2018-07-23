package com.example.androidui;

import android.app.Activity;
import com.example.androidui.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.ProgressBar;
//import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.app.ProgressDialog;

public class FirstActivity extends Activity {
	
	//private ImageView imageView=(ImageView)findViewById(R.id.image_view);
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_layout);
		Button button=(Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
				startActivity(intent);
				
			}
		});
		Button button2=(Button)findViewById(R.id.button2);
		/*
		 * 匿名内部类如果使用局部变量，那么这个局部变量需要final修饰，以防止变量值改变
		 */
		final ImageView imageView=(ImageView)findViewById(R.id.image_view);
		
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imageView.setImageResource(R.drawable.img_2);
				
			}
		});
		final ProgressBar progressBar=(ProgressBar)findViewById(R.id.progress_bar);
		Button button3=(Button)findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int progress=progressBar.getProgress();
				progress=progress+10;
				progressBar.setProgress(progress);
				
			}
		});
		/*
		 * AlterDialog可以在当前的界面弹出一个对话框，这个对话框是置顶于所有界面元素之上，能够屏蔽掉其他控件的交互能力
		 * AlterDialo没有layout，通过new来创建
		 * 
		 * 
		 */
		Button button4=(Button)findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder dialog=new AlertDialog.Builder(FirstActivity.this);
				dialog.setTitle("This is a Dialog");
				dialog.setMessage("Something import");
				dialog.setCancelable(false);
				dialog.setPositiveButton("OK",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				
				dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				dialog.show();
			}
		});
		/*
		 * ProgressDialog都可以在界面上弹出一个对话框，能够屏蔽其他控件的交互能力
		 * ProgressDialog会在对话框中显示一个进度条，一般用于表示当前操作比较耗时，让用户耐心地等待
		 * 
		 */
		Button button5=(Button)findViewById(R.id.button5);
		button5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ProgressDialog progressDialog=new ProgressDialog(FirstActivity.this);
				progressDialog.setTitle("This is a ProgressDialog");
				progressDialog.setMessage("Loading....");
				progressDialog.setCancelable(true);
				progressDialog.show();
				
				
			}
		});
		Button button6=(Button)findViewById(R.id.button6);
		button6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(FirstActivity.this,ForthActivity.class);
				startActivity(intent);
				
			}
		});
		
	}

}
