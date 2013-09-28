package com.example.northamericanwildlifesounds;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

import com.example.northamericanwildlifesounds.R;




public class Animallist extends Activity {
	private ArrayList<Animal> animalList_database; 	//contain a array list of Animal class
	private ListView animallist;
	
	private String[]animals= {"bobcat","coyote","deer","fox","mountainlion","possum",
							  "rabbit","raccoon","squirrel","turkey"};
	
	

/*reorder function
 * @param take in the list of animal name to be shorted based on A-Z alphabet. 
 * @return ordered animal name
 */
	private String[] reorder(String[]animal){
		//implement your code here
		return null;
	}
	
	
	
	/*addToAnimalListDatabase function
	 * @param take in the list of animal name and create a new animal class for each animal.
	 *       for each animal class:
	 *       	initialize animal sound,imageURL,sound, and type variable
	 *        once all the animal class is created, add them to animalList_database.
	 * 
	 */
	private void addToAnimalListDatabase(String[]animal){
		//implement your code here	
			
	}
		
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animallist);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animallist, menu);
		return true;
	}
	
	
	
	private void initializeVariable(){
		
		
	

		
	}

}


