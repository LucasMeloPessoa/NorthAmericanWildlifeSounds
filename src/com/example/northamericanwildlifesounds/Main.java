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



public class Main extends Activity {

	private Button learn, play;
	private ViewSwitcher switcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeVariable();   // call this method to initialize variables
		
		
		learn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			
			
			public void onClick(View v) {
				
				 //OurSoundPlayer.playSound(this, 4); //trying to play a sound! 
				// TODO Auto-generated method stub
				Intent animallist= new Intent("com.example.northamericanwildlifesounds.ANIMALLIST");
				animallist.putExtra("MODE", "SEEINGIMPAIRED");
				startActivity(animallist);
			}
		});
	
		play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent game= new Intent("com.example.northamericanwildlifesounds.GAME");
				startActivity(game);
			}
		});
	
	
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
		play=(Button)findViewById(R.id.playButton);
	
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
