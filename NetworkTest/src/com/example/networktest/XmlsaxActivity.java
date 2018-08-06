package com.example.networktest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import java.io.StringReader;


import javax.xml.parsers.SAXParserFactory;

public class XmlsaxActivity extends Activity {
	
	private TextView responseText=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xmlsax_layout);
		responseText=(TextView)findViewById(R.id.xmlsaxtext);
		Button xmlsaxButton=(Button)findViewById(R.id.xmlsaxbutton);
		xmlsaxButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				xmlSaxWithHttpConnection();
			}
		});
		
		
	}
	
	private void xmlSaxWithHttpConnection(){
		
		new Thread(new Runnable(){
			
		@Override
		public void run(){
		URL url=null;
		BufferedReader buff=null;
		HttpURLConnection connection=null;
		try{
			url=new URL("http://192.168.43.147:80/data.xml");
			connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(8000);
			connection.setReadTimeout(8000);
			InputStream in=connection.getInputStream();
			buff=new BufferedReader(new InputStreamReader(in));
			String line;
			StringBuilder response=new StringBuilder();
			while((line=buff.readLine())!=null){
				response.append(line);
			}
			parserXMLWithSAX(response.toString());
			
		    }catch(Exception e){
			e.printStackTrace();
		}finally{
			if(buff!=null){
				try{
				buff.close();}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			if(connection!=null){
	         connection.disconnect();
		}
		
	}}}).start();


}
	
	private void parserXMLWithSAX(String data){
		try{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			XMLReader xmlReader=factory.newSAXParser().getXMLReader();
			MyHandler myHandler=new MyHandler();
			xmlReader.setContentHandler(myHandler);
			xmlReader.parse(new InputSource(new StringReader(data)));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	}
