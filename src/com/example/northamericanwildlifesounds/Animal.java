package com.example.northamericanwildlifesounds;


public class Animal {

	 private String name, imageURL, sound, type;

	 
	 
	//Constructor that initialize all variables
	public Animal( String name, String imageURL, String sound, String type){
		this.name=name;
		this.imageURL=imageURL;
		this.sound=sound;
		this.type=type;
		
	}
	
	/*return Animal Name*/
	public String getAnimalName(){
		return name;
	}
	/*return Animal ImageURL*/
	public String getAnimalImageURL(){
		return imageURL;
	}
	/*return Animal sound*/
	public String getAnimalsound(){
		return sound;
	}
	/*return Animal type*/
	public String getAnimalType(){
		return type;
	}
	
	
	/*add Animal Name*/
	public void addAnimalName( String input){
		name=input;
	}
	/*add Animal sound mp3 is raw folder*/
	public void addAnimalSound( String input){
		sound=input;
	}	
	/*add Animal imageURL that contain in drawable folder*/
		public void addAnimalImageURL( String input){
		imageURL=input;
	}
	/*add Animal type */
	public void addAnimalType( String input){
		type=input;
	}
	
}
