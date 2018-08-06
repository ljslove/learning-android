package com.example.networktest;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import java.lang.Runnable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.widget.TextView;
import org.xmlpull.v1.*;

import java.io.StringReader;
import android.util.Log;

public class XmlpullActivity extends Activity {
	
	private TextView responseText=null;
	private StringBuilder text=new StringBuilder();
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xmlpull_layout);
		Button sendRequest=(Button)findViewById(R.id.pullxml);
		responseText=(TextView)findViewById(R.id.pulltext);
		sendRequest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			sendRequestWithHttpConnection();
				
			}
		});
	}
	
	
	private void sendRequestWithHttpConnection(){
		
		new Thread(new Runnable(){
			
			@Override
			public void run(){
				HttpURLConnection connection=null;
				BufferedReader buff=null;
				try{
					URL url=new URL("http://192.168.43.147:80/data.xml");
					connection=(HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.setReadTimeout(8000);
					connection.setConnectTimeout(8000);
					InputStream in=connection.getInputStream();
					buff=new BufferedReader(new InputStreamReader(in));
					StringBuilder response=new StringBuilder();
					String line;
					while((line=buff.readLine())!=null){
							response.append(line);}
					parseXMLWithPull(response.toString());
					showResponse(text.toString());
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						if(buff!=null){
							try{
								buff.close();
							}catch(Exception e){
								e.printStackTrace();
							}
						}
						if(connection!=null){
							connection.disconnect();
						}
					}				
				
			}
		
}).start();

      }
	
	private void showResponse(final String response){
		
		runOnUiThread(new Runnable(){
			@Override
			public void run(){
				responseText.setText(response);
			}
		});
		
		
		
		
	}
	
	private void parseXMLWithPull(String data){
		
		final int nodeA=XmlPullParser.START_TAG;
		final int nodeB=XmlPullParser.END_TAG;
		
		try{
			/*
			 * 通过XmlPullParserFactory工厂模式来获取XmlPullParser对象
			 
			 */
			XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
			XmlPullParser xmlPullParser=factory.newPullParser();
			/*
			 * 将String数据变为流后，使用setInput方法，将流放入到XmlPullParser对象中进行解析
			 * 
			 */
			xmlPullParser.setInput(new StringReader(data));
			
			/*
			 * 
			 * 获取事件类型，当前的事件类型为START_DOCUMENT
			 */
			int eventType=xmlPullParser.getEventType();
			String id="";
			String name="";
			String version="";
			while(eventType!=xmlPullParser.END_DOCUMENT){
				/*
				 * 获取当前事件的标签的值
				 */
				String nodeName=xmlPullParser.getName();
				switch(eventType){
				case nodeA:{
					/*
					 * 当标签的值分别为id,name,version时，取出其内容的值
					 * 
					 */
					if("id".equals(nodeName)){
						id=xmlPullParser.nextText();
					}else if("name".equals(nodeName)){
						name=xmlPullParser.nextText();
					}else if("version".equals(nodeName)){
						version=xmlPullParser.nextText();
					}
					break;
					
				}
				
				
				case nodeB:{
					if("app".equals(nodeName)){
						Log.d("XmlpullActivity","id is"+id);
						text.append("id is "+id+"\n");
						Log.d("XmlpullActivity","name is"+name);
						text.append("name is "+name+"\n");
						Log.d("XmlpullActivity","version is"+version);
						text.append("version is "+version+"\n");
					}
					break;
			}
				default:
					break;
				
			
		}
				/*
				 * 
				 * 获取下一个事件类型，比如当前事件类型是START_DOCUMENT，下一个事件类型是START_TAG
				 * 当前事件类型为START_TAG，标签为<apps>，下一个事件类型也为START_TAG，标签值为<app>
				 */
				eventType=xmlPullParser.next();
		
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


