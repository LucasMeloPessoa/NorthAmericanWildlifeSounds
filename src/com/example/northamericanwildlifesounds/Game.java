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
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Game extends Activity implements View.OnClickListener {

	 private List<Animal> displayList;
	 Button back,play,next;
	 GridView gridView;
	 TextView infoDisplay, score, stock;
	 int headCount,childrenCount,count, numOfImages;
	 MediaPlayer mPlayer;
	 GridViewAdapter gridViewadapter;
	 int [] buffer;
	 final Context context = this; 
	 
	 
	protected void onCreate(Bundle savedInstanceState) {
		if(Global.stock <= 0) { // so stock 3 when first on.
			Global.stock = 3;
			Global.score=0;
			Global.lose=false;
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
			initalizeVariables();
			generateRandomList();
			
			
		gridViewadapter=new GridViewAdapter(this,displayList);
		 gridView.setAdapter(gridViewadapter);
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	        @SuppressLint("NewApi")
			public void onItemClick(AdapterView<?> parent, final View view,int position, long id) {
	    
	        	mPlayer.pause();
	        	if(Global.choosenAnimal.getName().equalsIgnoreCase(displayList.get(position).getName())){
	        	//Toast.makeText(getApplicationContext(),"GREAT JOB!", Toast.LENGTH_SHORT).show();	
	        		infoDisplay.setText("Great Job! You did it!");
	        		
	        		
		        	Global.score+=10;
		        	score.setText("SCORE: "+Global.score);
		        	stock.setText("    STOCK: "+Global.stock);
					mPlayer.stop();
					mPlayer = MediaPlayer.create(getBaseContext(), R.raw.right);
					mPlayer.start();
					
		
					generateRandomList();
					gridViewadapter.notifyDataSetChanged();
					//gridView.invalidateViews();
					view.setAlpha(1);
			
	        		
	        	

	        	
	        	}
	        	else{
	        		//Toast.makeText(getApplicationContext(),"Sorry, please try again!", Toast.LENGTH_SHORT).show();
	        		infoDisplay.setText("Sorry. Try Again!");
		        	//Global.score-=10;
		        	//score.setText("SCORE: "+Global.score);
					Global.stock --;
		        	stock.setText("    STOCK: "+Global.stock);
					mPlayer = MediaPlayer.create(getBaseContext(), R.raw.wrong);
					mPlayer.start();
					mPlayer=MediaPlayer.create(getBaseContext(), Global.choosenAnimal.getSound());
					

		        	if(Global.stock <= 0) {

		    
				    			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				    			// set title
				    			if(Global.score >= Global.highScore) { 
				          			Global.highScore = Global.score;
				    				alertDialogBuilder.setTitle("Congratulations - New Record!");		    				
				    			} else {
				    				alertDialogBuilder.setTitle("Game Over!");
				    			}
				    	 
				    			// set dialog message
				    			alertDialogBuilder
				    			.setMessage("High Score: " + Global.highScore + "  Continue?")
				    			.setCancelable(false)
				    			.setPositiveButton("No",new DialogInterface.OnClickListener() {
				    				public void onClick(DialogInterface dialog,int id) {
				    					// if this button is clicked, close
				    					// current activity
				    					Game.this.finish();
				    					}
				    				})
				    				.setNegativeButton("Yes",new DialogInterface.OnClickListener() {
				    					public void onClick(DialogInterface dialog,int id) {
				    						// if this button is clicked, just close
				    						// the dialog box and do nothing
				    						dialog.cancel();
				    					}
				    				});
				    	 
				    				// create alert dialog
				    				AlertDialog alertDialog = alertDialogBuilder.create();
				    	 
			    					// show it
			    					alertDialog.show();
				    		//	*/
		        				
			    					Global.score = 0;
			    					score.setText("SCORE: "+Global.score);
			    					Global.stock = 3;
			    					stock.setText("    STOCK: "+Global.stock);
		        				
		        	
		        	
		        			

		        	}
		        	
		        }
	        //	infoDisplay.setText("Can you guess the sound?");
        }
      }); 
		mPlayer.start();
		
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
		mPlayer.stop();
		finish();
	}

	
	public void generateRandomList(){
	
		//clear old data and insert new 4 animals'data
		int []headPosition;
		int []childPosition;
		boolean copy=true;
		displayList.clear();
		headPosition=shuffleArray(headCount);
		if(headPosition.length>=numOfImages){
		for(int i=0;i<numOfImages;i++){
			
			childrenCount=Global.animalChild.get(Global.animalHeader.get(headPosition[i])).size();
			childPosition=shuffleArray(childrenCount);
			displayList.add(Global.animalChild.get(Global.animalHeader.get(headPosition[i])).get(childPosition[0]));
			if(copy){
				Global.choosenAnimal=Global.animalChild.get(Global.animalHeader.get(headPosition[i])).get(childPosition[0]);
				mPlayer=MediaPlayer.create(getBaseContext(), Global.choosenAnimal.getSound());
				copy=false;
			}
		}
		}
		else
		{
			Toast.makeText(getApplicationContext(),"ERROR: Game.java- animal number is less than numOfImages. Try add more animals or resize numofImage", Toast.LENGTH_SHORT).show();
		}
		Collections.shuffle(displayList);
		
	}
	
	public int[] shuffleArray(int size){
		
		buffer=null;	//clear memory
		buffer=new int[size];
	    Random rnd = new Random();
	    int k;
	    for (k =1; k<=size;k++)
	    {
	    	buffer[k-1]=k-1;
		      int index = rnd.nextInt(k);
		      int a = buffer[index];
		      buffer[index] = buffer[k-1];
		      buffer[k-1] = a;

	    }
	    if(count>=childrenCount){
	    	count=0;
	    }
	    count++;
		return buffer;
	}
	
	public void initalizeVariables(){
		
		back=(Button)findViewById(R.id.b_backGame);
			back.setOnClickListener(this);
		play=(Button)findViewById(R.id.b_playGame);
			play.setOnClickListener(this);
		next=(Button)findViewById(R.id.b_nextGame);
			next.setOnClickListener(this);
		infoDisplay=(TextView)findViewById(R.id.tv_displayGame);
			infoDisplay.setText("Can you guess the sound?");
		score=(TextView)findViewById(R.id.tv_score);
		stock=(TextView)findViewById(R.id.tv_stock);
	    score.setText("SCORE: "+Global.score);
	    stock.setText("    STOCK: "+Global.stock);
		gridView = (GridView)findViewById(R.id.gridview);
		headCount=Global.animalHeader.size();
		displayList= new ArrayList<Animal>();
		numOfImages=4;
		count=0;
	
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
	
		switch (v.getId()) {
		case R.id.b_backGame: //reset button
			mPlayer.stop();
			mPlayer = MediaPlayer.create(getBaseContext(), R.raw.reset);
			mPlayer.start();
			infoDisplay.setText("Can you guess the sound?");
			generateRandomList();
			gridViewadapter.notifyDataSetChanged();
			//gridView.invalidateViews();
			v.setAlpha(1);
			Global.score = 0;
			score.setText("SCORE: "+Global.score);
			Global.stock = 3;
        	stock.setText("    STOCK: "+Global.stock);  	
			break;
		case R.id.b_playGame:
			infoDisplay.setText("Can you guess the sound?");
			mPlayer.seekTo(0);
			mPlayer.start();
			break;
		case R.id.b_nextGame: //skip button
			mPlayer.stop();
			//mPlayer = MediaPlayer.create(getBaseContext(), R.raw.skip);
			mPlayer.start();
			mPlayer=MediaPlayer.create(getBaseContext(), Global.choosenAnimal.getSound());
			
			infoDisplay.setText("Can you guess the sound?");
			generateRandomList();
			gridViewadapter.notifyDataSetChanged();
			//gridView.invalidateViews();
			v.setAlpha(1);
			Global.score-=10;
			//mPlayer = MediaPlayer.create(getBaseContext(), R.raw.wrong);
			mPlayer.start();
			mPlayer=MediaPlayer.create(getBaseContext(), Global.choosenAnimal.getSound());
			
			score.setText("SCORE: "+Global.score);
        	//score.setText("SCORE: "+Global.score);
        	if(Global.score < 0) {
        		//infoDisplay.setText("Game Over!");
    			mPlayer.stop();
    			infoDisplay.setText("Can you guess the sound?");
    			generateRandomList();
    			gridViewadapter.notifyDataSetChanged();
    			//gridView.invalidateViews();
    			//v.setAlpha(1);
    			Global.score = 0;
    			score.setText("SCORE: "+Global.score);
    			Global.stock = 3;
            	stock.setText("    STOCK: "+Global.stock); 
        	}
			break;
		
			
		}
			
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	
}
