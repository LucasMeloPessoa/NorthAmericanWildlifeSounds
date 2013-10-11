package com.example.northamericanwildlifesounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
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
	private Animal animalClk;
	

	HashMap<String, Integer> sound, imageURL;
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
        //work
        
        /*
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Object e = (Object)listAdapter.getChild(groupPosition, childPosition);
                
                
                System.out.println("WHAT OBJECT ARE YOU?");
                
            	//HashMap<String, List<Animal>> animalChild = (HashMap)listAdapter.getChild(groupPosition, childPosition);
                //doing some work for child
				
				Intent game = new Intent("com.example.northamericanwildlifesounds.SOUNDDISPLAY");
				//game.putExtra("map", animalChild);
				startActivity(game);
				return true;
            }
        });
        */
        
        expListView.setOnChildClickListener(new OnChildClickListener() {
     	   
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                /*Toast.makeText(
                        getApplicationContext(),
                        animalHeader.get(groupPosition)  + " : " + animalChild.get( animalHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                        .show();
                */
                
                
                //THIS IS MANUALLY ADDED. IT IS SUPPOSELY TO BE ADDED at beginning
                animalClk=animalChild.get( animalHeader.get(groupPosition)).get(childPosition);
                if(animalClk.getSound()== -1){
                animalClk.addSound(getSoundFile(animalClk.getName()));  
                }
                if(animalClk.getImageURL()== -1){
                animalClk.addImageURL(getImageURLFile(animalClk.getName())); //get Image ID of this animal
                }
                Intent soundDP = new Intent("com.example.northamericanwildlifesounds.SOUNDDISPLAY");
                soundDP.putExtra("name", animalClk.getName());
                soundDP.putExtra("sound", animalClk.getSound());
                soundDP.putExtra("image", animalClk.getImageURL());
                startActivity(soundDP);
                
                return false;
            }
        });
        
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView parent, View v,  int groupPosition, long id) {
       
        
                if(animalChild.get(animalHeader.get(groupPosition)).size()==1){
                    
                    animalClk=new Animal();
                    animalClk.addName(animalHeader.get(groupPosition));
                    if(animalClk.getSound()== -1){ animalClk.addSound(getSoundFile(animalClk.getName())); }
                    if(animalClk.getImageURL()== -1){animalClk.addImageURL(getImageURLFile(animalClk.getName())); 
                    }
                    Intent soundDP = new Intent("com.example.northamericanwildlifesounds.SOUNDDISPLAY");
                    soundDP.putExtra("name", animalClk.getName());
                    soundDP.putExtra("sound", animalClk.getSound());
                    soundDP.putExtra("image", animalClk.getImageURL());
                    startActivity(soundDP);
                    
                    
                }
                return false;
            }
        });
        
        
        
 
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
        animalCategory=new String[]{ "Bobcat", "Coyote", "Deer", "Fox",
    			"Mountain Lion", "Possum", "Rabbit", "Raccoon", "Squirrel", 
    			"Turkey","Duck","Elephant","Chicken" };
        
       
        // Adding Animal Head data
        animalCategory=sortStringArray(animalCategory);	//to be sorted.
   		for(int i=0;i<animalCategory.length;i++){
        animalHeader.add(animalCategory[i]);
   		}

 
        // Adding child data
   		List<Animal>deer = new ArrayList<Animal>();
   		deer.add(new Animal("Doe Grunt", getSoundFile("doe_grunt"), getImageURLFile("doe_grunt")));
   		deer.add(new Animal("Buck Grunt", getSoundFile("buck_grunt"), getImageURLFile("buck_grunt")));
   		deer.add(new Animal("Buck Bawl", getSoundFile("buck_bawl"), getImageURLFile("buck_brawl")));
   		deer.add(new Animal("Contact Call", getSoundFile("contact_call"), getImageURLFile("contact_call")));
   	
   		List<Animal>bobcat = new ArrayList<Animal>();
   		bobcat.add(new Animal("Bobcat1", getSoundFile("bobcat1"), getImageURLFile("bobcat")));
   		bobcat.add(new Animal("Bobcat2", getSoundFile("bobcat2"), getImageURLFile("bobcat")));
   		
   		List<Animal>duck = new ArrayList<Animal>();
   		duck.add(new Animal("Duck Quack", getSoundFile("duck"), getImageURLFile("duck_quack")));
   		duck.add(new Animal("Duck Swimming", getSoundFile("duck swimming"), getImageURLFile("duck_swimming")));
 

 
        animalChild.put("Deer", deer); // Header, Child data
        animalChild.put("Bobcat", bobcat);
        animalChild.put("Duck", duck);
       
        
    }

    /**
     * WARNING: Make sure you put a image file in res/drawable folder 
     * @param file
     * @return
     */
    private int getImageURLFile(String file) {
		return getResources().getIdentifier(file, "drawable", "com.example.northamericanwildlifesounds");
	
}

    
    /**
     * WARNING: Make sure you put a sound file in res/raw folder 
     * @param file
     * @return
     */
    private int getSoundFile(String file) {
    		return getResources().getIdentifier(file, "raw", "com.example.northamericanwildlifesounds");
    	
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
