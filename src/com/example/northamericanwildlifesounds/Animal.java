package com.example.northamericanwildlifesounds;


public class Animal {
	private  String name, nameTag;
	
	private int sound,imageURL;
	
	
	
	//constructor
	public Animal(String name, String tag, int soundfile, int image){
		this.name=name;
		nameTag=tag;
		sound=soundfile;
		imageURL=image;
	}
	
	// second constructor
	public Animal(){
		name=null;
		sound=-1;	// negative means invalid ID
		imageURL=-1;
		nameTag=null;
	}
	

	
	public void addNameTag(String input){
		if (input!=null){
			nameTag=input;
		}
	}
	
	public void addName(String input){
		if (input!=null){
			name=input;
		}
	}
	
	public void addSound(int input){
			sound=input;
	}
	
	public void addImageURL(int input){
		imageURL=input;
}

	public String getNameTag(){
		return name;
	}
	public String getName(){
		return name;
	}
	
	public int getSound(){
		return sound;
	}
	
	public int getImageURL(){
		return imageURL;
	}
	
}
