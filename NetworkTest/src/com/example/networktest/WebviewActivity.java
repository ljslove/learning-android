package com.example.networktest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
 * 
 * WebView�ؼ����ں�̨������HTTP���󣬽��շ�������Ӧ���������������Լ����յ�ҳ��չʾ
 * ��װ�Ⱥܸ�
 * WebViewClient��Ҫ����WebView�������֪ͨ�������¼�������ҳ����������ת��
 * WebSettings��Ҫ����WebView������
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
