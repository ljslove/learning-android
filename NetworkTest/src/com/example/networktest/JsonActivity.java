package com.example.networktest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;
import android.util.Log;

public class JsonActivity extends Activity {
	 private TextView responseText=null;
	 private StringBuilder text=new StringBuilder();
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.json_layout);
		Button sendRequest=(Button)findViewById(R.id.jsonbutton);
		responseText=(TextView)findViewById(R.id.jsontext);
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
					URL url=new URL("http://192.168.43.147:80/data.json");
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
					parseJSONWithJSONObject(response.toString());
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
	
	private void parseJSONWithJSONObject(String jsonData){
		try{
			JSONArray jsonArray=new JSONArray(jsonData);
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				String id=jsonObject.getString("id");
				text.append("id is "+id+"\n");
				String name=jsonObject.getString("name");
				text.append("name is "+name+"\n");
				String version=jsonObject.getString("version");
				text.append("version is "+version+"\n");
				Log.d("JsonActivity","id is "+id);
				Log.d("JsonActivity","name is "+name);
				Log.d("JsonActivity","version is "+version);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	}


