package com.example.mycontentprovider;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

public class MainActivity extends Activity {
	
	
	private String newId1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_layout);
	        /*
	         * 向内容提供器中添加数据
	         * 调用ContentResolver的insert方法
	         * 
	         */
	     
	        Button addData=(Button)findViewById(R.id.add_data);
	        
	        addData.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Uri uri=Uri.parse("content://com.example.mycontentprovider.provider/book");
					// TODO Auto-generated method stub
					ContentValues values=new ContentValues();
					values.put("author","Tom");
					values.put("price",105.23);
					values.put("name","The Sea");
					Uri uri1=getContentResolver().insert(uri, values);
					newId1=uri1.getPathSegments().get(1);
					values.clear();
					values.put("author","Sun");
					values.put("price",85.26);
					values.put("name","The Sun");
					getContentResolver().insert(uri, values);
					
					values.clear();
							
				}
			});
	        /*
	         * 查询数据
	         * 调用ContentResolver的query方法
	         * 
	         */
	        Button queryData=(Button)findViewById(R.id.query_data);
	        queryData.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Uri uri=Uri.parse("content://com.example.mycontentprovider.provider/book");
					Cursor cursor=null;
					cursor=getContentResolver().query(uri,null,null,null,null);
					if(cursor!=null){
						while(cursor.moveToNext()){
							String author=cursor.getString(cursor.getColumnIndex("author"));
							Double price=cursor.getDouble(cursor.getColumnIndex("price"));
							String name=cursor.getString(cursor.getColumnIndex("name"));
							Log.d("MainActivity","author is "+author);
							Log.d("MainActivity","price is "+price);
							Log.d("MainActivity","name is "+name);
						}
						cursor.close();
					}
					
					
				}
			});
	        /*
	         * 更新数据
	         * 调用ContentResolver的update方法
	         * 
	         */
	        Button updateDate=(Button)findViewById(R.id.update_data);
	        updateDate.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Uri uri=Uri.parse("content://com.example.mycontentprovider.provider/book");
					ContentValues values=new ContentValues();
					values.put("price", 110);
					getContentResolver().update(uri, values,"author=?",new String[]{"Tom"});	
				}
			});
	        /*
	         * 删除数据
	         * 调用ContentResolver的delete方法
	         * 
	         */
	        Button deleteData=(Button)findViewById(R.id.delete_data);
	        deleteData.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Uri uri=Uri.parse("content://com.example.mycontentprovider.provider/book/"+newId1);
					Log.d("MainActivity","newId1 "+newId1);
					getContentResolver().delete(uri,null,null);
					
					
				}
			});
	        
	}

}
