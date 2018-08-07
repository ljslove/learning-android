package com.example.androidservicetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.ComponentName;
import android.os.IBinder;
import android.util.Log;

public class FirstActivity extends Activity implements View.OnClickListener {
	
	private final int UPDATE_TEXT=1;
	
	private TextView changeText;
	
	/*
	 * ����һ��handler��Ա���������ڴ���sendMessage��handleMessage
	 * ���̲߳��ܸ���UI������ʹ��handler������
	 */
	
	private Handler handler;
	
	/*
	 * 
	 * ����һ��Binder�ĳ�Ա�����������ڻ���κεط��Ϳ��Ե���MyBinderService.DownloadBinder�ķ�����
	 */
	
	private MyBinderService.DownloadBinder downloadBinder;
	
	/*
	 * ����һ��ServiceConnection����ͨ�����������԰󶨷���
	 * 
	 */
	
	private ServiceConnection connection=new ServiceConnection(){
		
		@Override
		public void onServiceDisconnected(ComponentName name){
			
		}
		@Override
		public void onServiceConnected(ComponentName name,IBinder service){
			downloadBinder=(MyBinderService.DownloadBinder)service;
			downloadBinder.startDownload();
			downloadBinder.getProgress();
		}
		
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_layout);
		Button changeButton=(Button)findViewById(R.id.changetext);
		Button startService=(Button)findViewById(R.id.startservice);
		Button stopService=(Button)findViewById(R.id.stopservice);
		Button bindService=(Button)findViewById(R.id.bindservice);
		Button unbindService=(Button)findViewById(R.id.unbindservice);
		Button threadService=(Button)findViewById(R.id.threadservice);
		Button intentService=(Button)findViewById(R.id.intentservice);
		bindService.setOnClickListener(this);
		unbindService.setOnClickListener(this);
		changeButton.setOnClickListener(this);
		startService.setOnClickListener(this);
		stopService.setOnClickListener(this);
		threadService.setOnClickListener(this);
		intentService.setOnClickListener(this);
		changeText=(TextView)findViewById(R.id.textview);
		handler=new Handler(){
			
			/*
			 * 
			 * (non-Javadoc)
			 * @see android.os.Handler#handleMessage(android.os.Message)
			 * 
			 * ������������Ϣ�����message��what�ֶ���UPDATA_TEXT����ô�͸���UI
			 * 
			 */
			
			@Override
			public void handleMessage(Message msg){
				
				switch(msg.what){
				case UPDATE_TEXT:
					changeText.setText("I have changed");
					break;
					default:
						break;
					
				}
				
				
			}
			
		};
		
	}
	
	
	
	
	@Override
	public void onClick(View v){
		
		switch(v.getId()){
		case R.id.changetext:
			
			/*
			 * ����һ�����̣߳����ڷ���message
			 * 
			 */
			new Thread(new Runnable(){
				
				@Override
				public void run(){
					Message message=new Message();
					message.what=UPDATE_TEXT;
					handler.sendMessage(message);
				}
				
			}).start();
			break;
			
			/*
			 * ͨ������һ��Intent����ʹ��startService������������������
			 */
		case R.id.startservice:
			Intent intent1=new Intent(FirstActivity.this,MyService.class);
			startService(intent1);
			break;
			/*
			 * ͨ������һ��Intent����ʹ��stopService����������ֹͣ����
			 */
		case R.id.stopservice:
			Intent intent2=new Intent(FirstActivity.this,MyService.class);
			stopService(intent2);
			break;
			/*
			 * �󶨷���
			 */
		case R.id.bindservice:
			Intent intent3=new Intent(FirstActivity.this,MyBinderService.class);
			bindService(intent3,connection,BIND_AUTO_CREATE);
			break;
			/*
			 * ������
			 */
		case R.id.unbindservice:
			unbindService(connection);
			break;
			/*
			 * ʹ��Thread���ڷ����д���һ�����߳�
			 */
		case R.id.threadservice:
			Intent intent4=new Intent(FirstActivity.this,MyThreadService.class);
			Log.d("FirstActivity","Thread id is "+Thread.currentThread().getId());
			startService(intent4);
			break;
			/*
			 * ʹ��IntentService�ڷ����д���һ�����߳�
			 */
		case R.id.intentservice:
			Intent intent5=new Intent(FirstActivity.this,MyIntentService.class);
			Log.d("FirstActivity", "Thread id is "+Thread.currentThread().getId());
			startService(intent5);
			default:
				break;
		}
		
	}

}
