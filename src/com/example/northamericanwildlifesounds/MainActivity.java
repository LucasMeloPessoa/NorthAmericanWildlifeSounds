// erased all crap 03:40pm
// Lucas 6th commit.
// David 7th commit...
// Lucas 7th commit.
// Lucas 8th commit (after pull and then push)
// David 8th commit
// David's 9th commit
//David's 10th commit
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
