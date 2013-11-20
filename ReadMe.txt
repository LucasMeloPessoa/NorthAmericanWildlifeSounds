NorthAmericanWildlifeSounds 
version: 0.9
Date: November-20-2013

Directions on how to add new content such as sounds, pictures, and animals.

How to put new Sounds:

	We recommend using .ogg files for sounds.
	NorthAmericanWildlifeSounds/res/raw/

	Example how to access them in the code:
		mPlayer=MediaPlayer.create(getBaseContext(), Global.choosenAnimal.getSound());
		mPlayer = MediaPlayer.create(getBaseContext(), R.raw.<putSoundNameHere>);

How to put new Pictures:
	NorthAmericanWildlifeSounds/res/drawable-hdpi/
	We recommend using .png
	For animal pictures we recommend the dimensions 481x608

How add new Animal:

	Go into NorthAmericanWildlifeSounds/src/com.example.northamericanwildlifesounds/Main.java
		
		animalCategory = new String[] { "Bobcat", "Coyote", "<putAnimalNameHere>"}
				
		<putAnimalNameHere>.add(new Animal("<nameToDisplayForThatSound>", "<putAnimalNameHere>", getSoundFile("<putNameOfSoundFile>"), getImageURLFile("<putNameOfPictureFile>")));

		Global.animalChild.put("<putAnimalNameHere>", <putAnimalNameHere>);