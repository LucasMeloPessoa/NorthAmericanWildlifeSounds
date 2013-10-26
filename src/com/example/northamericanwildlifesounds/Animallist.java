package com.example.northamericanwildlifesounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;


import android.widget.Toast;



import com.example.northamericanwildlifesounds.R;

public class Animallist extends Activity {

							
	private String[] animalCategory;


	String head_Clicked,currentScreenview;

	HashMap<String, Integer> sound, imageURL;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    ListView listViewDisplayer;
    String classID_SD;
String chicken;
    
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
    
        if( Global.currentMode.equalsIgnoreCase("ACCESSIBILITY"))
        	setContentView(R.layout.activity_animallist_ver_b);
        else
        	setContentView(R.layout.activity_animallist);
        
        
        initializeVariables();

        if( Global.currentMode.equalsIgnoreCase("ACCESSIBILITY")){
    	     final ListViewAdapter adapter = new ListViewAdapter(this, android.R.layout.simple_list_item_1, Global.animalHeader);
    	    
            
    	    listViewDisplayer.setAdapter(adapter);
    	    listViewDisplayer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    	        public void onItemClick(AdapterView<?> parent, final View view,int position, long id) {
    	        	

  	        			Global.selectedAnimal= (String) parent.getItemAtPosition(position);
  	        			Global.selectedHeadAnimal=Global.selectedAnimal;
  	        			//Toast.makeText(getApplicationContext(),Global.selectedAnimal +" Clicked!", Toast.LENGTH_SHORT).show();	
  	        			if(Global.animalChild.get(Global.selectedHeadAnimal).size()<2){
  	        				processData(position,0,classID_SD);
  	        			}
  	        			else{
  	        		   Intent intent = new Intent("com.example.northamericanwildlifesounds.SUBLISTVIEW");
  	        		   startActivity(intent);
  	        			}
    	        }
    	      }); 
        }

        else{
        	expListView.setOnChildClickListener(new OnChildClickListener() {
     	   
            @Override
            	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
         
            		Global.selectedAnimal= (String) Global.animalChild.get(Global.animalHeader.get(groupPosition)).get(childPosition).getName();
            		processData(groupPosition,childPosition,classID_SD);
            		return false;
            	}
        	});
        
        	expListView.setOnGroupClickListener(new OnGroupClickListener() {
        		public boolean onGroupClick(ExpandableListView parent, View v,  int groupPosition, long id) {
        			Global.selectedAnimal= (String) parent.getItemAtPosition(groupPosition);
        			Global.selectedHeadAnimal=Global.selectedAnimal;
        			if(Global.animalChild.get(Global.animalHeader.get(groupPosition)).size()==1){
        				processData(groupPosition,0,classID_SD);
        			}	
        			return false;
        		}
        	});

    
        listAdapter = new ExpandableListAdapter(this, Global.animalHeader, Global.animalChild);
        expListView.setAdapter(listAdapter);
        
      
        }
        
    }

    private  void processData(int groupPosition, int childPosition, String classID){
    	
        Global.choosenAnimal=Global.animalChild.get( Global.animalHeader.get(groupPosition)).get(childPosition);
            if( Global.choosenAnimal.getNameTag()!=null){
            	if( Global.choosenAnimal.getImageURL()== -1){ Global.choosenAnimal.addImageURL(getImageURLFile( Global.choosenAnimal.getNameTag())); }
            	if( Global.choosenAnimal.getSound()== -1){ Global.choosenAnimal.addSound(getSoundFile( Global.choosenAnimal.getNameTag())); }
            }

        Intent soundDP=new Intent(classID);
        startActivity(soundDP);
   	
   }
    
    
    private void initializeVariables() {
        // get the listview
    
        expListView = (ExpandableListView) findViewById(R.id.elvAnimallist);
        listViewDisplayer=(ListView)findViewById(R.id.lv_display);
        currentScreenview="listview1";
       // animalHeader = new ArrayList<String>();
        //animalChild = new HashMap<String, List<Animal>>();
        setUpAnimalData();	
        chicken="chickenn";
        classID_SD="com.example.northamericanwildlifesounds.SOUNDDISPLAY";
        
    }
    

    
    private void setUpAnimalData(){    
    	
    	if(Global.animalHeader==null){
    		Global.animalHeader= new ArrayList<String>();
    	
        //INSERT MAIN ANIMAL HERE
        animalCategory=new String[]{ "Bobcat", "Coyote", "Deer", "Fox",
    			"Mountain Lion", "Possum", "Rabbit", "Raccoon", "Squirrel", 
    			"Turkey"}; // "DUCK
        
        // Adding Animal Head data
        animalCategory=sortStringArray(animalCategory);	//to be sorted.
   		for(int i=0;i<animalCategory.length;i++){
        Global.animalHeader.add(animalCategory[i]);
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
       
    	}
    }

    
    /**
     * WARNING:refering image file in res/drawable folder 
     * @param file
     * @return
     */
    private int getImageURLFile(String file) {
		return getResources().getIdentifier(file, "drawable", "com.example.northamericanwildlifesounds");
	
}

    
    /**
     * WARNING:referring sound file must be in res/raw folder 
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
