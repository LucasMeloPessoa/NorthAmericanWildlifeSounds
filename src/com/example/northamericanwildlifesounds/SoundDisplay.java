package com.example.northamericanwildlifesounds;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class SoundDisplay extends Activity {
	
	private Button play;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound_display);
		
		initializeVariable();
		
		
		
		
		// /*
		play.setOnClickListener(new View.OnClickListener() {
			MediaPlayer mPlayer = MediaPlayer.create(getBaseContext(), R.raw.mountainlion); // in 2nd param u have to pass your desire ringtone
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("CHECKING IF IT WORKS");
				
				
				if(v.getId() == R.id.button1) {
				//mPlayer = MediaPlayer.create(getBaseContext(), R.raw.mountainlion); // in 2nd param u have to pass your desire ringtone
				//mPlayer.prepare();
				//mPlayer.seekTo(0);
				mPlayer.start();
				
				//Intent game= new Intent("com.example.northamericanwildlifesounds.GAME");
				//startActivity(game);
				}
			}
		});
		// */
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sound_display, menu);
		return true;
	}
	
	
	
	private void initializeVariable(){
		
		play=(Button)findViewById(R.id.button1);
	
	}

}
