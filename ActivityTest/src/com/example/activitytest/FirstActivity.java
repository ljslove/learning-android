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
		super.onCreate(savedInstanceState);   //���ø�����onCreate()����
		setContentView(R.layout.first_layout);  //����ǰ�Ļ����һ������
		Button button1=(Button)findViewById(R.id.button_1);
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(FirstActivity.this,"You click button 1", Toast.LENGTH_SHORT).show();
			}
		});
		 /*
		  * ʹ����ʾ��Intent�������
		  * Intentһ�㱻��������������������Լ����͹㲥
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
		  * ʹ����ʽ��Intent������һ���
		  *
		  * ��Ҫ��AndroidManifest�ļ��У��������<intent-filter>
		  * ��һ�����<intent-filter>��һ��Intent��action��categoryƥ��ʱ��
		  * �������������
		  * action+category�������
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
		  * Intent�������÷���������ʽIntent������������Ӧ�õĻ
		  * ʹ��schemeЭ�飬��������������
		  * action+scheme�������
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
		  *����ϵͳ���Ž���
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
		  * �Լ�����һ��data������Ӧ��
		  * intent+action+�Զ�����scheme�������
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
		  * ʹ��Intent�ڻ֮�䴫������
		  * ʹ��intent����һ�����������
		  * �ֽ����鴫�ݸ�һ����ֵ�ԣ�������һ��������ٰ�ֵ�Ӽ�ֵ��ȡ����
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
		  * ����Intent����һ�����������
		  * ������һ���ʱ��Ҫʹ��startActivityForResult()�������򷵻�
		  * ��������onActivityReslt()�����л�ȡ
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
		/*
		 * 使用MIME Type来启动活动,MIME Type表明Activity可以处理的数据类型
		 * MIME为可以处理的数据类型，可以为标准的MIME，也可以是自定义的
		 * 以下程序为调用图库
		 *
		 *
		 */
		Button button18=(Button)findViewById(R.id.button_18);
		button18.setOnClickListener(new View.OnClickListener() {

		 @Override
		 public void onClick(View v) {
			 // TODO Auto-generated method stub
			 Intent intent=new Intent(Intent.ACTION_VIEW);
			 intent.setType("image/jpeg");
			 startActivity(intent);

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







	/*��res�д�����menu�Ĳ��ֺ�����Ҫ���˵����ּ��ص����

	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);  //����ǰ������˵�
		return true;   //true��ʾ�����Ĳ˵���ʾ��false��ʾ�����Ĳ˵�����ʾ

	}

	/*
	 * �ڼ��ز˵�������Ҫ�����˵���Ӧ�¼�
	 * Ϊʲô������Toast����������this��������FirstActivity��this
	 * ͨ������getItemId���ж����ǵ��������ĸ��˵���
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
