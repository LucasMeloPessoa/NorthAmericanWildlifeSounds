package com.example.northamericanwildlifesounds;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SoundDisplay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound_display);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sound_display, menu);
		return true;
	}

}
