package com.example.northamericanwildlifesounds;

import com.example.northamericanwildlifesounds.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Intro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartPoint = new Intent("com.example.wildlifesounds_version2.MAINACTIVITY");
					startActivity(openStartPoint);//when this is called, on pause is called after
				}
			}
		};
		timer.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.intro, menu);
		return true;
	}

	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}


