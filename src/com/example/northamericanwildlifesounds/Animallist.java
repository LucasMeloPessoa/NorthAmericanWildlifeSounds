package com.example.northamericanwildlifesounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

import android.widget.Toast;

import com.example.northamericanwildlifesounds.R;

public class Animallist extends Activity {
	private String[] animalCategory;
	HashMap<String, Integer> sound, imageURL;
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	ListView listViewDisplayer;
	String classID_SD, head_Clicked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Global.currentMode.equalsIgnoreCase("ACCESSIBILITY"))
			setContentView(R.layout.activity_animallist_ver_b);
		else
			setContentView(R.layout.activity_animallist);

		initializeVariables();

		if (Global.currentMode.equalsIgnoreCase("ACCESSIBILITY")) {
			final ListViewAdapter adapter = new ListViewAdapter(this,
					android.R.layout.simple_list_item_1, Global.animalHeader);

			listViewDisplayer.setAdapter(adapter);
			listViewDisplayer
					.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						public void onItemClick(AdapterView<?> parent,
								final View view, int position, long id) {

							Global.selectedAnimal = (String) parent
									.getItemAtPosition(position);
							Global.selectedHeadAnimal = Global.selectedAnimal;
							// Toast.makeText(getApplicationContext(),"YOUR_TEXT_HERE", Toast.LENGTH_SHORT).show();
							if (Global.animalChild.get(
									Global.selectedHeadAnimal).size() < 2) {
								processData(position, 0, classID_SD);
							} else {
								Intent intent = new Intent(
										"com.example.northamericanwildlifesounds.SUBLISTVIEW");
								startActivity(intent);
							}
						}
					});
		}

		else {
			expListView.setOnChildClickListener(new OnChildClickListener() {

				@Override
				public boolean onChildClick(ExpandableListView parent, View v,
						int groupPosition, int childPosition, long id) {

					Global.selectedAnimal = (String) Global.animalChild
							.get(Global.animalHeader.get(groupPosition))
							.get(childPosition).getName();
					processData(groupPosition, childPosition, classID_SD);
					return false;
				}
			});

			expListView.setOnGroupClickListener(new OnGroupClickListener() {
				public boolean onGroupClick(ExpandableListView parent, View v,int groupPosition, long id) {
				//	Global.selectedAnimal = (String) parent.getItemAtPosition(groupPosition);
					Global.selectedAnimal=(String)Global.animalHeader.get(groupPosition);
					Global.selectedHeadAnimal = Global.selectedAnimal;
					
					if (Global.animalChild.get(Global.animalHeader.get(groupPosition)).size() == 1) {
						processData(groupPosition, 0, classID_SD);
					}
					return false;
				}
			});

			listAdapter = new ExpandableListAdapter(this, Global.animalHeader,
					Global.animalChild);
			expListView.setAdapter(listAdapter);

		}

	}

	private void processData(int groupPosition, int childPosition,
			String classID) {
		Global.choosenAnimal = Global.animalChild.get(
				Global.animalHeader.get(groupPosition)).get(childPosition);
		if (Global.choosenAnimal.getNameTag() != null) {
			if (Global.choosenAnimal.getImageURL() == -1) {
				Global.choosenAnimal
						.addImageURL(getImageURLFile(Global.choosenAnimal
								.getNameTag()));
			}
			if (Global.choosenAnimal.getSound() == -1) {
				Global.choosenAnimal.addSound(getSoundFile(Global.choosenAnimal
						.getNameTag()));
			}
		}
		Intent soundDP = new Intent(classID);
		startActivity(soundDP);
	}

	private void initializeVariables() {
		expListView = (ExpandableListView) findViewById(R.id.elvAnimallist);
		listViewDisplayer = (ListView) findViewById(R.id.lv_display);
		classID_SD = "com.example.northamericanwildlifesounds.SOUNDDISPLAY";
	}

	private int getImageURLFile(String file) {
		return getResources().getIdentifier(file, "drawable",
				"com.example.northamericanwildlifesounds");
	}

	private int getSoundFile(String file) {
		return getResources().getIdentifier(file, "raw",
				"com.example.northamericanwildlifesounds");
	}

}
