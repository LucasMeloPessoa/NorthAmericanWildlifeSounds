package com.example.northamericanwildlifesounds;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import com.example.northamericanwildlifesounds.R;

public class Animallist extends ListActivity {
	private ArrayList<Animal> animal_database; // contain a array list of Animal
												// class
	private ListView animallist;

	private String[] animalClass = { "bobcat", "coyote", "deer", "fox",
			"mountainlion", "possum", "rabbit", "raccoon", "squirrel", "turkey" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_animallist);
		setListAdapter(new ArrayAdapter<String>(Animallist.this,
				android.R.layout.simple_list_item_1, animalClass));


	}

	/**
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 *           menu; this adds items to the action bar if it is present.
	 *           getMenuInflater().inflate(R.menu.animallist, menu); return
	 *           true; }
	 **/

	private void initializeVariable() {

	}

	/*
	 * reorder function
	 * 
	 * @param take in the list of animal name to be shorted based on A-Z
	 * alphabet.
	 * 
	 * @return ordered animal name
	 */
	private String[] reorder(String[] animal) {
		// implement your code here
		return null;
	}

	/*
	 * addToAnimalListDatabase function
	 * 
	 * @param take in the list of animal name and create a new animal class for
	 * each animal. for each animal class: initialize animal
	 * sound,imageURL,sound, and type variable once all the animal class is
	 * created, add them to animalList_database.
	 */
	private void addToAnimalListDatabase(String[] animal) {
		// implement your code here

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	/**
	 * this onListItemClick method will be called when user click on any item on
	 * the list above
	 **/
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String clickedAnimal = animalClass[position]; // store animal name that
														// user click
		try {
			Class ourClass = Class
					.forName("com.example.northamericanwildlifesounds.AnimalListSub");

			Intent ourIntent = new Intent(Animallist.this, ourClass); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
