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
import android.widget.ListView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ListView;

import android.widget.Toast;



import com.example.northamericanwildlifesounds.R;

public class Animallist extends Activity {

	private ArrayList<Animal> list;										
	private String[] animalCategory;
	private Animal animalClk;
	Intent intent;
	String mode;

	HashMap<String, Integer> sound, imageURL;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    ListView listViewDisplayer;
    List<String>animalHeader;
    HashMap<String, List<Animal>> animalChild;
    
    
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // preparing list data
        intent = getIntent();
        mode=intent.getStringExtra("MODE");
       
        if(mode.equalsIgnoreCase("SEEINGIMPAIRED"))
        setContentView(R.layout.activity_animallist_ver_b);
        else
        	setContentView(R.layout.activity_animallist);
        
        initializeVariables();

        if(mode.equalsIgnoreCase("SEEINGIMPAIRED")){
        	
        }

        else{
        expListView.setOnChildClickListener(new OnChildClickListener() {
     	   
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                /*Toast.makeText(getApplicationContext(),"your_Text_here", Toast.LENGTH_SHORT).show();
                */
                
                
                //THIS IS MANUALLY ADDED. IT IS SUPPOSELY TO BE ADDED at beginning
                animalClk=animalChild.get( animalHeader.get(groupPosition)).get(childPosition);
                if(animalClk.getNameTag()!=null){
                	if(animalClk.getImageURL()== -1){animalClk.addImageURL(getImageURLFile(animalClk.getNameTag())); }
                	if(animalClk.getSound()== -1){animalClk.addSound(getSoundFile(animalClk.getNameTag())); }
                
                Intent soundDP =setUpIntent(animalClk);
                startActivity(soundDP);
                }
            
                return false;
            }
        });
        
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView parent, View v,  int groupPosition, long id) {
       
        
                if(animalChild.get(animalHeader.get(groupPosition)).size()==1){
       
                    animalClk=animalChild.get(animalHeader.get(groupPosition)).get(0);
                    if(animalClk.getNameTag()!=null){
                    	if(animalClk.getSound()== -1){ animalClk.addSound(getSoundFile(animalClk.getName())); }
                    	if(animalClk.getImageURL()== -1){animalClk.addImageURL(getImageURLFile(animalClk.getName())); }
                    }
                    Intent soundDP = setUpIntent(animalClk);
                    startActivity(soundDP);
                    
                    
                }
                
                return false;
            }
        });
        
   
        if(mode.equalsIgnoreCase("SEEINGIMPAIRED")){
        	    ListViewAdapter adapter = new ListViewAdapter(this,
        		        android.R.layout.simple_list_item_1, animalHeader);
        	    listViewDisplayer.setAdapter(adapter);
        }
        else{
        listAdapter = new ExpandableListAdapter(this, animalHeader, animalChild);
        expListView.setAdapter(listAdapter);
        }
      
        }
        
    }
    private  Intent setUpIntent(Animal animalClk){
    	Intent soundDP;
    	soundDP= new Intent("com.example.northamericanwildlifesounds.SOUNDDISPLAY");
        soundDP.putExtra("name", animalClk.getName());
        soundDP.putExtra("sound", animalClk.getSound());
        soundDP.putExtra("image", animalClk.getImageURL());
        soundDP.putExtra("nameTag", animalClk.getNameTag());
    	
    	return soundDP;
    }
    
    

    private void initializeVariables() {
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.elvAnimallist);
        listViewDisplayer=(ListView)findViewById(R.id.lv_display);
        animalHeader = new ArrayList<String>();
        animalChild = new HashMap<String, List<Animal>>();
        setUpAnimalData();	
        

        
    }
    
    
    
    
    
    private void setUpAnimalData(){    
        //INSERT MAIN ANIMAL HERE
        animalCategory=new String[]{ "Bobcat", "Coyote", "Deer", "Fox",
    			"Mountain Lion", "Possum", "Rabbit", "Raccoon", "Squirrel", 
    			"Turkey" }; // "DUCK
        
        // Adding Animal Head data
        animalCategory=sortStringArray(animalCategory);	//to be sorted.
   		for(int i=0;i<animalCategory.length;i++){
        animalHeader.add(animalCategory[i]);
   		}

   		
   	/** function Prototype
   	 * Animal Deer=new Animal(String DisplayName, String NameTag, int sound, int imageURL)
   	 * DisplayName is the name you want to display on the screen 
   	 * NameTag is the same name as the sound or image file name(Make sure these names are matched!)
   	 * sound is the sound ID of the animal. 
   	 * imageURL is the image ID of the animal. 
   	 * **/
  
   		List<Animal>bobcat = new ArrayList<Animal>();
   		bobcat.add(new Animal("Bobcat", "bobcat", getSoundFile("bobcat"), getImageURLFile("bobcat")));
   		bobcat.add(new Animal("Bobcat1", "bobcat", getSoundFile("bobcat1"), getImageURLFile("bobcat")));
   		bobcat.add(new Animal("Bobcat2", "bobcat", getSoundFile("bobcat2"), getImageURLFile("bobcat")));
   		bobcat.add(new Animal("Bobcat3", "bobcat", getSoundFile("bobcat3"), getImageURLFile("bobcat")));
   		//bobcat.add(new Animal("Bobcat Growl", getSoundFile("bobcat1"), getImageURLFile("bobcat")));
   		//bobcat.add(new Animal("Bobcat Roar", getSoundFile("bobcat2"), getImageURLFile("bobcat")));
   		//bobcat.add(new Animal("Bobcat Snarl", getSoundFile("bobcat2"), getImageURLFile("bobcat")));
   		
   		List<Animal>coyote = new ArrayList<Animal>();
   		coyote.add(new Animal("Coyote", "coyote", getSoundFile("coyote"), getImageURLFile("coyote")));
   		//coyote.add(new Animal("Coyote", getSoundFile("coyote"), getImageURLFile("coyote")));
   		
   		List<Animal>deer = new ArrayList<Animal>();
   		deer.add(new Animal("Deer", "deer", getSoundFile("deer"), getImageURLFile("deer")));
   		deer.add(new Animal("Deer", "deer", getSoundFile("deer"), getImageURLFile("deer")));
   		//deer.add(new Animal("Doe Grunt", getSoundFile("deer"), getImageURLFile("buck_grunt")));
   		//deer.add(new Animal("Buck Grunt", getSoundFile("buck_grunt"), getImageURLFile("buck_grunt")));
   		//deer.add(new Animal("Buck Bawl", getSoundFile("buck_bawl"), getImageURLFile("buck_brawl")));
   		//deer.add(new Animal("Contact Call", getSoundFile("contact_call"), getImageURLFile("contact_call")));
   		
   		/*
   		List<Animal>duck = new ArrayList<Animal>();
   		duck.add(new Animal("Duck Quack", getSoundFile("duck"), getImageURLFile("duck_quack")));
   		duck.add(new Animal("Duck Swimming", getSoundFile("duck swimming"), getImageURLFile("duck_swimming")));
 		*/
   		
   		List<Animal>fox = new ArrayList<Animal>();
   		fox.add(new Animal("Fox", "fox", getSoundFile("fox"), getImageURLFile("fox")));
   		//fox.add(new Animal("Fox", getSoundFile("fox"), getImageURLFile("fox")));
   		
   		List<Animal>mountainlion = new ArrayList<Animal>();
   		mountainlion.add(new Animal("Mountain Lion", "mountainlion", getSoundFile("mountainlion"), getImageURLFile("mountainlion")));
   		
   		List<Animal>possum = new ArrayList<Animal>();
   		possum.add(new Animal("Possum", "possum", getSoundFile("possum"), getImageURLFile("possum")));
   		
   		List<Animal>rabbit = new ArrayList<Animal>();
   		rabbit.add(new Animal("Rabbit", "rabbit", getSoundFile("rabbit"), getImageURLFile("rabbit")));
   		
   		List<Animal>raccoon = new ArrayList<Animal>();
   		raccoon.add(new Animal("Raccoon", "raccoon", getSoundFile("raccoon"), getImageURLFile("raccoon")));
   		
   		List<Animal>squirrel = new ArrayList<Animal>();
   		squirrel.add(new Animal("Squirrel", "squirrel", getSoundFile("squirrel"), getImageURLFile("squirrel")));
   		
   		List<Animal>turkey = new ArrayList<Animal>();
   		turkey.add(new Animal("Turkey", "turkey", getSoundFile("turkey"), getImageURLFile("turkey")));

 
        animalChild.put("Deer", deer); // Header, Child data
        animalChild.put("Bobcat", bobcat);
        animalChild.put("Coyote", coyote);
        animalChild.put("Fox", fox);
        animalChild.put("Mountain Lion", mountainlion);
        animalChild.put("Possum", possum);
        animalChild.put("Rabbit", rabbit);
        animalChild.put("Raccoon", raccoon);
        animalChild.put("Squirrel", squirrel);
        animalChild.put("Turkey", turkey);
       
        
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
