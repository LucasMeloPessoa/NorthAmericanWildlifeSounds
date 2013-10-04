package com.example.northamericanwildlifesounds;



import java.io.FileNotFoundException;

import android.os.Bundle;
import android.app.Activity;
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
		
			
		
		display.setText(soundd);
		display2.setText(soundb);
		
		
		
		
		
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
