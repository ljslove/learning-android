package com.example.mycontentprovider;

import android.content.ContentProvider;
import android.content.UriMatcher;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.database.sqlite.SQLiteDatabase;

public class MyContentProvider extends ContentProvider {
	
	public static final int BOOK_DIR=0;
	public static final int BOOK_ITEM=1;
	public static final int CATEGORY_DIR=2;
	public static final int CATEGORY_ITEM=3;
	private MyDatabaseHelper myDatabaseHelper;
	public static final String AUTHORITY="com.example.mycontentprovider.provider";
	private static UriMatcher uriMatcher;
	static{
		uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORITY,"book",BOOK_DIR);
		uriMatcher.addURI(AUTHORITY,"book/#",BOOK_ITEM);
		uriMatcher.addURI(AUTHORITY,"category",CATEGORY_DIR);
		uriMatcher.addURI(AUTHORITY,"category/#",CATEGORY_ITEM);
	}
	
	
	

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		myDatabaseHelper=new MyDatabaseHelper(getContext(),"BookStore.db",null,1);
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		Cursor cursor=null;
		SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();
		switch(uriMatcher.match(uri)){
		case BOOK_DIR:
			cursor=db.query("Book",projection, selection, selectionArgs,null,null,sortOrder);
			break;
		case BOOK_ITEM:
			 String bookId=uri.getPathSegments().get(1);
			cursor=db.query("Book",projection,"id=?",new String[]{bookId},null,null,sortOrder);
			break;
		case CATEGORY_DIR:
			cursor=db.query("Category",projection, selection, selectionArgs,null,null,sortOrder);
			break;
		case CATEGORY_ITEM:
			String categoryId=uri.getPathSegments().get(1);
			cursor=db.query("Category",projection,"id=?",new String[]{categoryId},null,null,sortOrder);
			break;
			default:
				break;
		}
		
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch(uriMatcher.match(uri)){
		case BOOK_DIR:
			return "vnd.android.cursor.dir/vnd.com.example.mycontentprovider.provider/Book";
		case BOOK_ITEM:
			return "vnd.android.cursor.item/vnd.com.example.mycontentprovider.provider/Book";
		case CATEGORY_DIR:
			return "vnc.android.cursor.dir/vnd.com.example.mycontentprovider.provider/Category";
		case CATEGORY_ITEM:
			return "vnd.android.cursor.item/vnd.com.example.mycontentprovider.provider/Category";
		}
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();
		Uri uriReturn=null;
		long insertRows=0;
		switch(uriMatcher.match(uri)){
		case BOOK_DIR:
		case BOOK_ITEM:
			insertRows=db.insert("Book",null, values);
			uriReturn=Uri.parse("Content://"+AUTHORITY+"/Book/"+insertRows);
			break;
		case CATEGORY_DIR:
		case CATEGORY_ITEM:
			insertRows=db.insert("Category",null, values);
			uriReturn=Uri.parse("Content://"+AUTHORITY+"/Category/"+insertRows);
			break;
			default:
				break;
			
		}
		return uriReturn;
	}
    /*
     * 
     * (non-Javadoc)
     * @see android.content.ContentProvider#delete(android.net.Uri, java.lang.String, java.lang.String[])
     * uri的path部分为/后面的，如content://com.example.mycontentprovider.provider/table1/#
     * table1/#就是path。
     * uri.getPathSegment()会得到path部分以/分割的List
     * get(1)就会得到#这个值
     * 
     */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();
		int deleteRows=0;
		switch(uriMatcher.match(uri)){
			case BOOK_DIR:
				deleteRows=db.delete("Book", selection, selectionArgs);
			    break;
			case BOOK_ITEM:
				String bookId=uri.getPathSegments().get(1);
				deleteRows=db.delete("Book","id=?",new String[]{bookId});
				break;
			case CATEGORY_DIR:
				deleteRows=db.delete("Category",selection,selectionArgs);
				break;
			case CATEGORY_ITEM:
				String categoryId=uri.getPathSegments().get(1);
				deleteRows=db.delete("Category","id=?",new String[]{categoryId} );
				break;
			default:
				break;
			
			
		}
		return deleteRows;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();
		int updateRows=0;
		switch(uriMatcher.match(uri)){
		case BOOK_DIR:
			updateRows=db.update("Book", values,selection,selectionArgs);
			break;
		case BOOK_ITEM:
			 String bookId=uri.getPathSegments().get(1);
			updateRows=db.update("Book", values,"id=?",new String[]{bookId});
			break;
		case CATEGORY_DIR:
			updateRows=db.update("Category", values,selection,selectionArgs);
			break;
		case CATEGORY_ITEM:
			String categoryId=uri.getPathSegments().get(1);
			updateRows=db.update("Category", values,"id=?",new String[]{categoryId});
			break;
			default:
				break;
		}
		return updateRows;
	}

}
