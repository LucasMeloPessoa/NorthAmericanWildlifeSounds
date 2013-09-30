package com.example.northamericanwildlifesounds;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AnimalListSub extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animalsub);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animal_list_sub, menu);
		return true;
	}

}
