package com.example.northamericanwildlifesounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Global {

	public static List<String> animalHeader;
	public static HashMap<String, List<Animal>> animalChild = new HashMap<String, List<Animal>>();
	public static List<String> tempHeader = new ArrayList<String>();
	public static String currentMode = "NORMAL";
	public static String selectedAnimal, selectedHeadAnimal;
	public static int groupID, childID, score, stock, highScore;
	public static boolean lose;
	public static Animal choosenAnimal = new Animal();
}