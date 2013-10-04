package com.example.northamericanwildlifesounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;



import com.example.northamericanwildlifesounds.R;

public class Animallist extends Activity {

	private ArrayList<Animal> list;										
	private String[] animalCategory;

	HashMap<String, List<Integer>> sound, imageURL;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String>animalHeader;
    HashMap<String, List<Animal>> animalChild;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animallist);
 
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.elvAnimallist);
 
        // preparing list data
        initializeVariables();
        listAdapter = new ExpandableListAdapter(this, animalHeader, animalChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
    }
 

    private void initializeVariables() {
        animalHeader = new ArrayList<String>();
        animalChild = new HashMap<String, List<Animal>>();
        
        //INSERT MAIN ANIMAL HERE
        animalCategory=new String[]{ "bobcat", "coyote", "deer", "fox",
    			"mountainlion", "possum", "rabbit", "raccoon", "squirrel", 
    			"turkey","duck","elephant","chicken" };
        
       
        // Adding Animal Head data
        animalCategory=sortStringArray(animalCategory);	//to be sorted.
   		for(int i=0;i<animalCategory.length;i++){
        animalHeader.add(animalCategory[i]);
   		}

 
        // Adding child data
   		List<Animal>deer = new ArrayList<Animal>();
   		deer.add(new Animal("Doe Grunt",40, 20));
   		deer.add(new Animal("Buck Grunt",40, 20));
   		deer.add(new Animal("Buck Bawl",40, 20));
   		deer.add(new Animal("Contact Call",40, 20));
   	
   		List<Animal>bobcat = new ArrayList<Animal>();
   		bobcat.add(new Animal("Bobcat Female",40, 20));
   	
   		List<Animal>duck = new ArrayList<Animal>();
   		duck.add(new Animal("Duck Quack",40, 20));
   		duck.add(new Animal("Duck Swimming",30,10));
 

 
        animalChild.put("deer", deer); // Header, Child data
        animalChild.put("bobcat", bobcat);
        animalChild.put("duck", duck);
        
    }

    
    private HashMap<String, List<Integer>> setImageURLData(String[] file) {
    	//IMPLEMENT YOUR CODE HERE
    	HashMap<String, List<Integer>> data=new HashMap<String, List<Integer>>() ;
    	
    	return data;
    }
      
    
    
    private HashMap<String, List<Integer>> setSoundData(String[] file) {
    	//IMPLEMENT YOUR CODE HERE
    	HashMap<String, List<Integer>> data=new HashMap<String, List<Integer>>() ;
    	int soundfile;
    	
    	for(int i=0;i<file.length;i++)
    	{
    		
    		
    		
    		
    		
    		
    	}
    	
    	
    	return data;
    }
    
    
    
    
   /**
    * 
    * @param file to be sorted in alphabet letter
    * return sorted array
    */
    
    private String[] sortStringArray(String[] file) {
    	
    	if(file == null)
    		return file;
    	
    	String[]data = file;
    	
    	for(int j = 0; j < data.length; j++)
    	{
    		for (int i = j + 1; i < data.length; i++)
    		{
    			if(data[i].compareTo(data[j]) < 0)
    			{
    				String temp = data[j];
    				data[j] = data[i];
    				data[i] = temp;
    			}
    		}
    	}
    	return data;
    
}
    
    


}
