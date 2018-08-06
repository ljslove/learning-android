package com.example.networktest;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import java.util.jar.Attributes;
import android.util.Log;

public class MyHandler extends DefaultHandler {
	
	private String nodeName;
	private StringBuilder id;
	private StringBuilder name;
	private StringBuilder version;
	
	@Override
	public void startDocument() throws SAXException{
		id=new StringBuilder();
		name=new StringBuilder();
		version=new StringBuilder();
		
	}
	
   
	public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException{
		nodeName=localName;
		Log.d("startElement","test");
		
		
	}
	
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException{
		if("id".equals(nodeName)){
			id.append(ch,start,length);
			Log.d("characters","id is "+id.toString());
		}else if("name".equals(nodeName)){
			name.append(ch,start,length);
		}else if("version".equals(nodeName)){
			version.append(ch,start,length);
		}
		
		
	}
	
	@Override
	public void endElement(String uri,String localName,String qName) throws SAXException{
		if("app".equals(localName)){
			Log.d("MyHandler","id is"+id.toString());
			Log.d("MyHandler","name is"+name.toString());
			Log.d("MyHandler","version is"+version.toString());
			id.setLength(0);
			name.setLength(0);
			version.setLength(0);
			
		}
		
	}
	
	public void endDocument() throws SAXException{
		super.endDocument();
		
		
	}
	
	
	
	
	

}
