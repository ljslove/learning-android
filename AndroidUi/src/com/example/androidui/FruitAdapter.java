package com.example.androidui;

import android.widget.ArrayAdapter;

import android.content.Context;
import java.util.List;

import com.example.androidui.R;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;

/*
 * 重写父类构造函数，用于将上下文，ListView子项布局和数据都传递进来
 * 重写getView（）方法，这个方法在每个子项被滚动到屏幕内的时候会被调用
 * 在getView方法中，首先通过getItem（）方法得到当前项的Fruit实例，然后使用LayoutInflater来为这个子项加载我们传入的布局
 * 
 */


public class FruitAdapter extends ArrayAdapter<Fruit> {
	private int resourceId;
	public FruitAdapter(Context context,int textViewResourceId,List<Fruit> objects){
		super(context,textViewResourceId,objects);
		resourceId=textViewResourceId;
	}
	
	@Override
	public View getView(int position,View covertView,ViewGroup parent){
		Fruit fruit=getItem(position);
		View view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
		ImageView fruitImage=(ImageView)view.findViewById(R.id.fruit_image);
		/*
		 * 调用View的findViewById方法分别获取到ImageView和TextView的实例
		 * 并分别调用它们的setImageResource()和setText()方法来设置显示的图片和文字，最后将布局返回
		 * 
		 * 
		 */
		TextView fruitName=(TextView)view.findViewById(R.id.fruit_name);
		fruitImage.setImageResource(fruit.getImageId());
		fruitName.setText(fruit.getName());
		
		return view;
		
	}

}
