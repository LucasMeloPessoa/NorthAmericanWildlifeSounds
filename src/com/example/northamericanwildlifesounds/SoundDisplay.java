package com.example.northamericanwildlifesounds;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class SoundDisplay extends Activity {
	
	private ImageView display;
	private Button play;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound_display);
		initializeVariable();
		display.setImageResource(Global.choosenAnimal.getImageURL());
		play.setOnClickListener(new View.OnClickListener() {
			MediaPlayer mPlayer = MediaPlayer.create(getBaseContext(), Global.choosenAnimal.getSound()); // In second parameter, you need to pass in your desired animal sound. 
			@Override
			public void onClick(View v) {

				if(v.getId() == R.id.b_play) {
				//mPlayer = MediaPlayer.create(getBaseContext(), R.raw.mountainlion);
				//mPlayer.prepare();
				//mPlayer.seekTo(0);
				mPlayer.start();
				
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
		display=(ImageView) findViewById(R.id.imageView1);
		play=(Button)findViewById(R.id.b_play);
	
	}

}
