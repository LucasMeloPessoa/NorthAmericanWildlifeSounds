package com.example.northamericanwildlifesounds;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class subListView extends Activity {

	ListView lvDisplayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animallist_ver_b);
		lvDisplayer = (ListView) findViewById(R.id.lv_display);

		// Clear tempHeader's old data before store a new data
		Global.tempHeader.clear();
		for (int i = 0; i < Global.animalChild.get(Global.selectedAnimal)
				.size(); i++) {
			Global.tempHeader.add(Global.animalChild.get(Global.selectedAnimal)
					.get(i).getName());
		}

		final ListViewAdapter adapter = new ListViewAdapter(this,
				android.R.layout.simple_list_item_1, Global.tempHeader);

		lvDisplayer.setAdapter(adapter);
		lvDisplayer
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					public void onItemClick(AdapterView<?> parent,
							final View view, int position, long id) {

						Global.selectedAnimal = (String) parent
								.getItemAtPosition(position);
						Global.choosenAnimal = Global.animalChild.get(
								Global.selectedHeadAnimal).get(position);
						Intent intent = new Intent(
								"com.example.northamericanwildlifesounds.SOUNDDISPLAY");
						startActivity(intent);
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view, menu);
		return true;
	}

}