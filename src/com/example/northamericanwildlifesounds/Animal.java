package com.example.northamericanwildlifesounds;


import java.util.ArrayList;

import android.app.Activity;

import com.example.northamericanwildlifesounds.R;
public class Animal extends Activity {

	 private String name;
	 private int sound, imageURL;
	 ArrayList<Animal> type;
	 
	 
	 
	 
	 
	//Constructor that initialize all variables
	public Animal( String name, int imageURL, int sound ){
		this.name=name;
		this.imageURL=imageURL;
		this.sound=sound;
		type= new ArrayList<Animal>();
		
		
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
	public ArrayList<Animal> getType(){
		return type;
	}
	
	
	/*add Animal Name*/
	public void addAnimalName( String input){
		name=input;
	}
	/*add Animal sound mp3 is raw folder*/
	public void addAnimalSound(int file){
		sound=file;
		
	}	
	/*add Animal imageURL that contain in drawable folder*/
		public void addAnimalImageURL( int input){
		imageURL=input;
	}
	public boolean containSound(int file){
			if(sound==file){
				return true;
			}
			else
				return false;
	}
	public boolean containImageURL(int file){
		if(imageURL==file){
			return true;
		}
		else
			return false;
}
	
	/*add Animal type */
	public void addAnimalType( String name, int sound, int img){
		//check see if type already exist, if not, add it.
		if(add name
	}
	
}
