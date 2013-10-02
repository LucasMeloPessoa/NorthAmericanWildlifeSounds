package com.example.northamericanwildlifesounds;


import android.app.Activity;

import com.example.northamericanwildlifesounds.R;
public class Animal extends Activity {

	 private String name, type;
	 private int sound, imageURL;
	 
	 
	 
	 
	 
	//Constructor that initialize all variables
	public Animal( String name, int imageURL, int sound, String type){
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
	public int getAnimalImageURL(){
		return imageURL;
	}
	/*return Animal sound*/
	public int getAnimalsound(){
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
	public void addAnimalSound( int input){
		sound=input;
	}	
	/*add Animal imageURL that contain in drawable folder*/
		public void addAnimalImageURL( int input){
		imageURL=input;
	}
	/*add Animal type */
	public void addAnimalType( String input){
		type=input;
	}
	
}
