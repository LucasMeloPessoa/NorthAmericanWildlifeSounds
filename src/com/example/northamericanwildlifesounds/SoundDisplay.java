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
	Animal animal_file;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound_display);
		
		initializeVariable();
		display.setImageResource(animal_file.getImageURL());
		
		
		
		
		// /*
		play.setOnClickListener(new View.OnClickListener() {
			MediaPlayer mPlayer = MediaPlayer.create(getBaseContext(), animal_file.getSound()); // in 2nd param u have to pass your desire ringtone
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//System.out.println("CHECKING IF IT WORKS");
				
				
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
		
		animal_file=new Animal();
		Intent intent = getIntent();
		animal_file.addName(intent.getStringExtra("name"));
		animal_file.addImageURL(intent.getIntExtra("image", -1));
		animal_file.addSound(intent.getIntExtra("sound", -1));
		animal_file.addNameTag(intent.getStringExtra("nameTag"));
		
		display=(ImageView) findViewById(R.id.imageView1);
		//play=(Button) findViewById(R.id.imDisplay);
		play=(Button)findViewById(R.id.button1);
	
	}

}
