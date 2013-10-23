package com.example.northamericanwildlifesounds;


import com.example.northamericanwildlifesounds.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;



public class Main extends Activity implements View.OnClickListener{

	private Button learn, play, mode;
	private ViewSwitcher switcher;
	
	private String currentMode="NORMAL";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeVariable();   // call this method to initialize variables

	
	}


	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
/**
 * initializeVariable method initialize variables
 * 
 */
	private void initializeVariable(){
		
		learn=(Button)findViewById(R.id.learnButton);
		learn.setOnClickListener(this);
		play=(Button)findViewById(R.id.playButton);
		play.setOnClickListener(this);
		mode=(Button)findViewById(R.id.b_mode);
		mode.setOnClickListener(this);
		mode.setText(currentMode +" MODE");
		
	
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}





	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.learnButton:
			Intent animallist= new Intent("com.example.northamericanwildlifesounds.ANIMALLIST");
			animallist.putExtra("MODE", currentMode);
			startActivity(animallist);
			break;
		case R.id.playButton:
			Intent game= new Intent("com.example.northamericanwildlifesounds.GAME");
			startActivity(game);
			break;
		case R.id.b_mode:
			if(currentMode.equalsIgnoreCase("ACCESSIBILITY")){
				currentMode="NORMAL";
				mode.setText(currentMode + " MODE");
			}
			else{
				currentMode="ACCESSIBILITY";
				mode.setText(currentMode + " MODE");
			}
			
			break;
		
			
		}
			
	}
}
