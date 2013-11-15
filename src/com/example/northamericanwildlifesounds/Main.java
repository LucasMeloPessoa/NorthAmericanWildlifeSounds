package com.example.northamericanwildlifesounds;

import java.util.ArrayList;
import java.util.List;

import com.example.northamericanwildlifesounds.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ViewSwitcher;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class Main extends Activity implements View.OnClickListener {

	private Button learn, play, mode;
	String classID_SD;
	String[] animalCategory;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeVariable(); // call this method to initialize variables
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
	private void initializeVariable() {

		learn = (Button) findViewById(R.id.learnButton);
		learn.setOnClickListener(this);
		play = (Button) findViewById(R.id.playButton);
		play.setOnClickListener(this);
		mode = (Button) findViewById(R.id.b_mode);
		mode.setOnClickListener(this);
		mode.setText(Global.currentMode + " MODE");
		classID_SD = "com.example.northamericanwildlifesounds.SOUNDDISPLAY";
		setUpAnimalData();
	}

	private void setUpAnimalData() {

		if (Global.animalHeader == null) {
			Global.animalHeader = new ArrayList<String>();

			// INSERT MAIN ANIMAL HERE
			animalCategory = new String[] { "Bobcat", "Coyote", "Deer", "Fox",
					"Mountain Lion", "Possum", "Rabbit", "Raccoon", "Squirrel",
					"Turkey" }; // "DUCK

			// Adding Animal Head data
			animalCategory = sortStringArray(animalCategory); // to be sorted.
			for (int i = 0; i < animalCategory.length; i++) {
				Global.animalHeader.add(animalCategory[i]);
			}

			/**
			 * function Prototype Animal Deer=new Animal(String DisplayName,
			 * String NameTag, int sound, int imageURL) DisplayName is the name
			 * you want to display on the screen NameTag is the same name as the
			 * sound or image file name(Make sure these names are matched!)
			 * sound is the sound ID of the animal. imageURL is the image ID of
			 * the animal.
			 * **/

			List<Animal> bobcat = new ArrayList<Animal>();
			bobcat.add(new Animal("Bobcat Snarling", "bobcat", getSoundFile("bobcat"),
					getImageURLFile("bobcat")));
			bobcat.add(new Animal("Bobcat Grumbling", "bobcat", getSoundFile("bobcat1"),
					getImageURLFile("bobcat")));
			bobcat.add(new Animal("Bobcat Grunting", "bobcat", getSoundFile("bobcat2"),
					getImageURLFile("bobcat")));
			bobcat.add(new Animal("Bobcat Roaring", "bobcat", getSoundFile("bobcat3"),
					getImageURLFile("bobcat")));
			// bobcat.add(new Animal("Bobcat Growl", getSoundFile("bobcat1"),
			// getImageURLFile("bobcat")));
			// bobcat.add(new Animal("Bobcat Roar", getSoundFile("bobcat2"),
			// getImageURLFile("bobcat")));
			// bobcat.add(new Animal("Bobcat Snarl", getSoundFile("bobcat2"),
			// getImageURLFile("bobcat")));

			List<Animal> coyote = new ArrayList<Animal>();
			coyote.add(new Animal("Coyote Howling", "coyote", getSoundFile("coyote"),
					getImageURLFile("coyote")));
			// coyote.add(new Animal("Coyote", getSoundFile("coyote"),
			// getImageURLFile("coyote")));

			List<Animal> deer = new ArrayList<Animal>();
			deer.add(new Animal("Deer Yelling", "deer", getSoundFile("deer"),
					getImageURLFile("deer")));
			// deer.add(new Animal("Doe Grunt", getSoundFile("deer"),
			// getImageURLFile("buck_grunt")));
			// deer.add(new Animal("Buck Grunt", getSoundFile("buck_grunt"),
			// getImageURLFile("buck_grunt")));
			// deer.add(new Animal("Buck Bawl", getSoundFile("buck_bawl"),
			// getImageURLFile("buck_brawl")));
			// deer.add(new Animal("Contact Call", getSoundFile("contact_call"),
			// getImageURLFile("contact_call")));

			/*
			 * List<Animal>duck = new ArrayList<Animal>(); duck.add(new
			 * Animal("Duck Quack", getSoundFile("duck"),
			 * getImageURLFile("duck_quack"))); duck.add(new
			 * Animal("Duck Swimming", getSoundFile("duck swimming"),
			 * getImageURLFile("duck_swimming")));
			 */

			List<Animal> fox = new ArrayList<Animal>();
			fox.add(new Animal("Fox Crying", "fox", getSoundFile("fox"),
					getImageURLFile("fox")));
			// fox.add(new Animal("Fox", getSoundFile("fox"),
			// getImageURLFile("fox")));

			List<Animal> mountainlion = new ArrayList<Animal>();
			mountainlion.add(new Animal("Mountain Lion Roaring", "mountainlion",
					getSoundFile("mountainlion"),
					getImageURLFile("mountainlion")));

			List<Animal> possum = new ArrayList<Animal>();
			possum.add(new Animal("Possum Snarling", "possum", getSoundFile("possum"),
					getImageURLFile("possum")));

			List<Animal> rabbit = new ArrayList<Animal>();
			rabbit.add(new Animal("Rabbit Panting", "rabbit", getSoundFile("rabbit"),
					getImageURLFile("rabbit")));

			List<Animal> raccoon = new ArrayList<Animal>();
			raccoon.add(new Animal("Raccoon Calling", "raccoon",
					getSoundFile("raccoon"), getImageURLFile("raccoon")));

			List<Animal> squirrel = new ArrayList<Animal>();
			squirrel.add(new Animal("Squirrel Squeaking", "squirrel",
					getSoundFile("squirrel"), getImageURLFile("squirrel")));

			List<Animal> turkey = new ArrayList<Animal>();
			turkey.add(new Animal("Turkey Calling", "turkey", getSoundFile("turkey"),
					getImageURLFile("turkey")));

			Global.animalChild.put("Deer", deer); // Header, Child data
			Global.animalChild.put("Bobcat", bobcat);
			Global.animalChild.put("Coyote", coyote);
			Global.animalChild.put("Fox", fox);
			Global.animalChild.put("Mountain Lion", mountainlion);
			Global.animalChild.put("Possum", possum);
			Global.animalChild.put("Rabbit", rabbit);
			Global.animalChild.put("Raccoon", raccoon);
			Global.animalChild.put("Squirrel", squirrel);
			Global.animalChild.put("Turkey", turkey);

			String [][][] keyd= new String[3][3][3];
			
		}
	}

	private Animal CreateAnimalEntry(String name, String name_Tag) {

		Animal file = null;
		try {
			file = new Animal(name, name_Tag, getSoundFile(name_Tag),
					getImageURLFile(name_Tag));
		} catch (Exception E) {
			file = new Animal(name, name_Tag, -1, -1);
		}

		return file;
	}

	private int getImageURLFile(String file) {
		return getResources().getIdentifier(file, "drawable",
				"com.example.northamericanwildlifesounds");

	}

	private int getSoundFile(String file) {
		return getResources().getIdentifier(file, "raw",
				"com.example.northamericanwildlifesounds");

	}

	/**
	 * 
	 * @param file
	 *            to be sorted in alphabet letter return sorted array
	 */

	private String[] sortStringArray(String[] file) {

		if (file == null)
			return file;

		String[] data = file;

		for (int j = 0; j < data.length; j++) {
			for (int i = j + 1; i < data.length; i++) {
				if (data[i].compareTo(data[j]) < 0) {
					String temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}
		}
		return data;

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.learnButton:
			Intent animallist = new Intent(
					"com.example.northamericanwildlifesounds.ANIMALLIST");
			animallist.putExtra("MODE", Global.currentMode);
			startActivity(animallist);
			break;
		case R.id.playButton:
			Intent game = new Intent(
					"com.example.northamericanwildlifesounds.GAME");
			startActivity(game);
			break;
		case R.id.b_mode:
			if (Global.currentMode.equalsIgnoreCase("ACCESSIBILITY")) {
				Global.currentMode = "NORMAL";
				mode.setText(Global.currentMode + " MODE");

			} else {
				Global.currentMode = "ACCESSIBILITY";
				mode.setText(Global.currentMode + " MODE");
			}

			break;

		}

	}
}
