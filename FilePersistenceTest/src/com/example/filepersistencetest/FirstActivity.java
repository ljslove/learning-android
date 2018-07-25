package com.example.filepersistencetest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;


public class FirstActivity extends Activity {
	
	private EditText saveEdit;
	private MyDatabaseHelper myDatabaseHelper=new MyDatabaseHelper(this,"BookStore.db",null,1);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_layout);
		Button saveButton=(Button)findViewById(R.id.filebutton);
		saveEdit=(EditText)findViewById(R.id.filetext);
		saveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String inputText=saveEdit.getText().toString();
				Log.d("FirstActivity","input text is "+inputText);
				saveFile(inputText);
				
				}
		});
	   Button readButton=(Button)findViewById(R.id.readfilebutton);
	   readButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String input=load();
			if(!TextUtils.isEmpty(input))
			saveEdit.setText(input);
			saveEdit.setSelection(input.length());

			
		}
	});
	   Button preSaveButton=(Button)findViewById(R.id.prebutton1);
	   preSaveButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SharedPreferences.Editor eidtor=getSharedPreferences("data",MODE_PRIVATE).edit();
			eidtor.putString("name","Tome");
			eidtor.putInt("age", 28);
			eidtor.putBoolean("married", false);
			eidtor.apply();
			
			
		}
	});
	   Button preReadButton=(Button)findViewById(R.id.prebutton2);
	   preReadButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SharedPreferences readpre=getSharedPreferences("data",MODE_PRIVATE);
			String name=readpre.getString("name","");
			int age=readpre.getInt("age", 0);
			Boolean mar=readpre.getBoolean("married", true);
			Log.d("FirstActivity","the name is "+name);
			Log.d("FirstActivity","the age is "+age);
			Log.d("FirstActivity","married is"+mar);
			
			
		}
	});
	   Button createDatabase=(Button)findViewById(R.id.createdatabase);
	   createDatabase.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		  myDatabaseHelper.getWritableDatabase();
			
		}
	});
	   Button addData=(Button)findViewById(R.id.adddata);
	   addData.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			SQLiteDatabase sql=myDatabaseHelper.getWritableDatabase();
			ContentValues values=new ContentValues();
			values.put("id", 1);
			values.put("author","Tom");
			values.put("price",45.23);
			values.put("pages",200);
			values.put("name","The Sea");
			sql.insert("Book", null, values);
			values.clear();
			values.put("id", 2);
			values.put("author","Max");
			values.put("price",100.56);
			values.put("pages",800);
			values.put("name","The Games");
			sql.insert("Book", null, values);
			
		}
	});
	   Button updatedata=(Button)findViewById(R.id.updatedata);
	   updatedata.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SQLiteDatabase sql=myDatabaseHelper.getWritableDatabase();
			ContentValues values=new ContentValues();
			values.put("price",300.45);
			sql.update("Book", values,"name=?", new String[]{"The Sea"});
			
		}
	});
	   Button deletedata=(Button)findViewById(R.id.deletedata);
	   deletedata.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SQLiteDatabase sql=myDatabaseHelper.getReadableDatabase();
			sql.delete("Book","author=?",new String[]{"Tom"});
			
		}
	});
	   Button retridata=(Button)findViewById(R.id.retridata);
	   retridata.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SQLiteDatabase sql=myDatabaseHelper.getWritableDatabase();
			Cursor cur=sql.query("Book",null,null,null,null, null,null);
			if(cur.moveToFirst()){
				do{
					String myauthor=cur.getString(cur.getColumnIndex("author"));
					Double myprice=cur.getDouble(cur.getColumnIndex("price"));
					int mypage=cur.getInt(cur.getColumnIndex("pages"));
					String myname=cur.getString(cur.getColumnIndex("name"));
					Log.d("FirstActivity","author is"+myauthor);
					Log.d("FirstActivitry","price is"+myprice);
					Log.d("FirstActivity","page is"+mypage);
					Log.d("FirstActivity","name is"+myname);
				}while(cur.moveToNext());
			}
			cur.close();
		
			
			
		}
	});
	   Button secondactivity=(Button)findViewById(R.id.updatedatabase);
	   secondactivity.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
			startActivity(intent);
			
		}
	});
	}
	   
	   public void saveFile(String inputText){
			
			FileOutputStream out=null;
			BufferedWriter writer=null;
			try{
				out=openFileOutput("data",Context.MODE_PRIVATE);
				writer=new BufferedWriter(new OutputStreamWriter(out));
				writer.write(inputText);
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{
					if(writer!=null){
						writer.close();
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
		}
	   
	   
	   
	   public String load(){
			
			FileInputStream in=null;
			BufferedReader reader=null;
			StringBuilder content=new StringBuilder();
			try{
				in=openFileInput("data");
				reader=new BufferedReader(new InputStreamReader(in));
				String line="";
				while((line=reader.readLine())!=null){
					
					content.append(line);
					
				}
				
			}catch(IOException e){
				e.printStackTrace();
				
			}finally{
				try{
					if(reader!=null){
						reader.close();
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
			return content.toString();
			
		}
	}
