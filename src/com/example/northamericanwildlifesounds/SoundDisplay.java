package com.example.northamericanwildlifesounds;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class SoundDisplay extends Activity implements View.OnClickListener{
	
	private ImageView display;
	private Button back, play;
	private TextView tview;
	private MediaPlayer mPlayer;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound_display);
		
		initializeVariable();
		display.setImageResource(Global.choosenAnimal.getImageURL());
		
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
			play.setOnClickListener(this); 
		back=(Button)findViewById(R.id.b_backSoundDisplay);
			back.setOnClickListener(this); 
		tview=(TextView)findViewById(R.id.tv_SoundPlayer);
		mPlayer = MediaPlayer.create(getBaseContext(), Global.choosenAnimal.getSound()); // In second parameter, you need to pass in your desired animal sound. 
		
		if(Global.currentMode.equalsIgnoreCase("NORMAL")){
			intent= new Intent("com.example.northamericanwildlifesounds.ANIMALLIST");
		}
		else{intent = new Intent("com.example.northamericanwildlifesounds.SUBLISTVIEW");}
		tview.setText(Global.choosenAnimal.getName());
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.b_backSoundDisplay:
			mPlayer.pause();
			startActivity(intent);
			break;
		case R.id.b_play:
			mPlayer.seekTo(0);
			mPlayer.start();
			break;
			
		}
		
	}

}
