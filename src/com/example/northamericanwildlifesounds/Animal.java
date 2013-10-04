package com.example.northamericanwildlifesounds;


public class Animal {
	private  String name;
	private int sound,imageURL;
	
	
	//constructor
	public Animal(String name, int soundfile, int image){
		this.name=name;
		sound=soundfile;
		imageURL=image;
	}
	

	
	public void addTypeName(String input){
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
