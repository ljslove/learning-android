package com.example.networktest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
 * 
 * WebView控件会在后台处理发送HTTP请求，接收服务器响应，解析返回数据以及最终的页面展示
 * 封装度很高
 * WebViewClient主要辅助WebView处理各种通知，请求事件，比如页面内链接跳转等
 * WebSettings主要设置WebView的属性
 * 
 */

public class WebviewActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview_layout);
		WebView webview=(WebView)findViewById(R.id.wview);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setWebViewClient(new WebViewClient());
		webview.loadUrl("http://192.168.43.147:80/data.xml");
		
	}

}
