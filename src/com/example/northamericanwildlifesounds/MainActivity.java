// 09-25-13 02:25
// I am trying something new.
//maybe I'll try too
// i hope we can get this to work....
// Raymonds new comment 
// Lucas 3rd eclipse commit.

// Raymond's 1st eclipse commit.

//Raymond's third eclipse commit 
//Lucas third eclipse commit.
// Lucas 4th commit
package com.example.northamericanwildlifesounds;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
