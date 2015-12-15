package com.example.mobiletraffic;

import org.apache.cordova.DroidGap;

import android.os.Bundle;

import android.view.Menu;

public class MainActivity extends DroidGap {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		//this.loadUrl("http://192.168.43.204:8080/MobileTraffic/caseManagement.jsp");
		//this.loadUrl("http://10.0.2.2:8080/MobileTraffic/login.jsp", 5000);
		this.loadUrl("file:///android_asset/login.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
