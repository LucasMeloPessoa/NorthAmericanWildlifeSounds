package com.example.northamericanwildlifesounds;



import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity implements View.OnClickListener {

	 private List<Animal> displayList;
	 Button back,play,next;
	 GridView gridView;
	 int numOfHeadAnimals, i;
	 MediaPlayer mPlayer;
	 GridViewAdapter gridViewadapter;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
			initalizeVariables();
			generateRandomList();
			
			
		gridViewadapter=new GridViewAdapter(this,displayList);
		 gridView.setAdapter(gridViewadapter);
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, final View view,int position, long id) {
	    
	        	
	        	Toast.makeText(getApplicationContext(),position+ " Clicked!", Toast.LENGTH_SHORT).show();	
      			
        }
      }); 

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	
	public void generateRandomList(){
		Random gen = new Random();
		//clear old data and insert new 4 animals'data
		int childrenCount,headPosition,childPosition;
		boolean copy=true;
		displayList.clear();
		for(i=0;i<4;i++){
			headPosition=gen.nextInt(numOfHeadAnimals);
			childrenCount=Global.animalChild.get(Global.animalHeader.get(headPosition)).size();
			childPosition=gen.nextInt(childrenCount);
			displayList.add(Global.animalChild.get(Global.animalHeader.get(headPosition)).get(childPosition));
			if(copy){
				Global.choosenAnimal=Global.animalChild.get(Global.animalHeader.get(headPosition)).get(childPosition);
				mPlayer=MediaPlayer.create(getBaseContext(), Global.choosenAnimal.getSound());
				copy=false;
			}
		}
		
		Collections.shuffle(displayList);
		
	}
	
	public void initalizeVariables(){
		
		back=(Button)findViewById(R.id.b_backGame);
		play=(Button)findViewById(R.id.b_playGame);
		next=(Button)findViewById(R.id.b_nextGame);
		gridView = (GridView)findViewById(R.id.gridview);
		numOfHeadAnimals=Global.animalHeader.size();
		displayList= new ArrayList<Animal>();

		
	
	}

	@Override
	public void onClick(View v) {
	
		switch (v.getId()) {
		case R.id.b_backGame:
			mPlayer.stop();
			Intent intent= new Intent("com.example.northamericanwildlifesounds.MAINACTIVITY");
			startActivity(intent);
			break;
		case R.id.playButton:
			mPlayer.seekTo(0);
			mPlayer.start();
			break;
		case R.id.b_nextGame:
			mPlayer.stop();
			generateRandomList();
			gridViewadapter.notifyDataSetChanged();
			gridView.invalidateViews();
			break;
		
			
		}
			
	}
	
	
}
