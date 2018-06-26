package com.example.activitytest;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class FirstActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);   //调用父类的onCreate()方法
		setContentView(R.layout.first_layout);  //给当前的活动加载一个布局
		Button button1=(Button)findViewById(R.id.button_1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(FirstActivity.this,"You click button 1", Toast.LENGTH_SHORT).show();
			}
		});
		 /*
		  * 使用显示的Intent来启动活动
		  * Intent一般被用于启动活动，启动服务以及发送广播
		  * 
		  */
		 Button button11=(Button)findViewById(R.id.button_11);
		 button11.setOnClickListener(new View.OnClickListener(){
			 @Override
			 
			 public void onClick(View v){
				 Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
				 startActivity(intent);
			 }
		 });
		 
		 
		 /*
		  * 使用隐式的Intent来启动一个活动
		  * 
		  * 需要在AndroidManifest文件中，给活动加入<intent-filter>
		  * 当一个活动的<intent-filter>和一个Intent的action和category匹配时，
		  * 才能启动这个活动
		  * action+category来启动活动
		  */
		 Button button12=(Button)findViewById(R.id.button_12);
		 button12.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("com.example.activitytest.ACTION_START");
				intent.addCategory("com.example.activitytest.MY_CATEGORY");
				startActivity(intent);
			}
		});
		 
		 /*
		  * Intent的其他用法，适用隐式Intent可以启动其他应用的活动
		  * 使用scheme协议，比如启动浏览器
		  * action+scheme来启动活动
		  * 
		  */
		 Button button13=(Button)findViewById(R.id.button_13);
		 button13.setOnClickListener(new View.OnClickListener(){
			 
			 public void onClick(View v)
			 {
				 Intent intent=new Intent(Intent.ACTION_VIEW);
				 intent.setData(Uri.parse("http://www.biadu.com"));
				 startActivity(intent);
			 }
		 });
		 
		 /*
		  *调用系统拨号界面 
		  * 
		  */
		 Button button14=(Button)findViewById(R.id.button_14);
		 button14.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);
				
			}
		});
		 /*
		  * 自己定义一个data来启动应用
		  * intent+action+自定义的scheme来启动活动
		  * 
		  */
		 Button button15=(Button)findViewById(R.id.button_15);
		 button15.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("com.example.activitytest.myaction");
				intent.setData(Uri.parse("everything://myhost"));
				startActivity(intent);
			}
		});
		 
		 /*
		  * 使用Intent在活动之间传递数据
		  * 使用intent向下一个活动传递数据
		  * 现将数组传递给一个键值对，启动另一个活动后，再把值从键值对取出来
		  * 
		  */
		 Button button16=(Button)findViewById(R.id.button_16);
		 button16.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String data="Hello FifthActivity";
				Intent intent=new Intent(FirstActivity.this,FifithActivity.class);
				intent.putExtra("extra_data", data);
				startActivity(intent);
				
			}
		});
		 /*
		  * 适用Intent向上一个活动返回数据
		  * 启动下一个活动时，要使用startActivityForResult()方法，则返回
		  * 的数组从onActivityReslt()方法中获取
		  * 
		  */
		 Button button17=(Button)findViewById(R.id.button_17);
		 button17.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(FirstActivity.this,SixthActivity.class);
				startActivityForResult(intent,1);
				
			}
		});
		 
	}
		 @Override
		 protected void onActivityResult(int requestCode,int resultCode,Intent data){
			 switch(requestCode){
			 case 1:
				 if(resultCode==RESULT_OK){
					 String returnData=data.getStringExtra("data_return");
					 Log.d("FirstActivity",returnData);
				 }
				 break;
			 default:
			 }
		 }
		 
		 
		 
		 
		 

	
	/*在res中创建了menu的布局后，需要将菜单布局加载到活动中
	 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);  //给当前活动创建菜单
		return true;   //true表示创建的菜单显示，false表示创建的菜单不显示
		
	}
	
	/*
	 * 在加载菜单后，需要定义菜单相应事件
	 * 为什么这里的Toast的上下文是this，而不是FirstActivity。this
	 * 通过调用getItemId来判断我们点击的是哪个菜单项
	 * 
	 */
	 public boolean onOptionsItemSelected(MenuItem item){
		 switch(item.getItemId()){
		 case R.id.add_item:
			 Toast.makeText(this, "You click add", Toast.LENGTH_SHORT).show();
			 break;
		 case R.id.remove_item:
			 Toast.makeText(this, "You click remove",Toast.LENGTH_SHORT).show();
			 break;
		 default:
		 }
	    return true;
		 
	 }
	
	
	
	

}

