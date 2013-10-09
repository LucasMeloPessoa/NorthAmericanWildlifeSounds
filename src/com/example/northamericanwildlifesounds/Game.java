package com.example.northamericanwildlifesounds;



import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Game extends Activity {

	int sound=R.raw.bobcat;
	private TextView display, display2;
	@Override
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
	
		display = (TextView) findViewById(R.id.tvDISPLAYSAMPLE);
		display2 = (TextView) findViewById(R.id.tvDISPLAYSAMPLE2);
		int soundb=getResources().getIdentifier("bobcat", "raw", "com.example.northamericanwildlifesounds");
		int soundd;
		
		soundd=getResources().getIdentifier("mainlogo", "drawable", "com.example.northamericanwildlifesounds");
		Intent intent = getIntent();
		//HashMap<String, List<Animal>> hashy = (HashMap) intent.getSerializableExtra("map");
		
		String hashyString = "NOTHING";
		
		//hashyString = (String) hashy.get("Doe Grunt").get(0).getName();
		
		//System.out.println(hashyString);
		
		/*
		for (HashMap.Entry<String, List<Animal>> entry : hashy.entrySet()) {
			hashyString = entry.getKey();
		}
		*/
		
		//String hashyString = hashy.entrySet().
		
			
		
		display.setText(soundd);
		//display2.setText(hashyString);
		
		System.out.println("WHERE ARE YOU ALREADY??????");
		System.out.println(hashyString);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	
	
	
}
