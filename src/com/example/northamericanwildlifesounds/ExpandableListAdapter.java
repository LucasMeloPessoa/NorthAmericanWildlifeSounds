package com.example.northamericanwildlifesounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> animalHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<Animal>> animalChild;
 
    public ExpandableListAdapter(Context context, List<String> listDataHeader,
            HashMap<String, List<Animal>> listChildData) {
        this._context = context;
        this.animalHeader = listDataHeader;
        this.animalChild = listChildData;
    }
    

 
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.animalChild.get(this.animalHeader.get(groupPosition))
              .get(childPosititon);
    	
      
    }
 
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
 
    @Override
    public View getChildView(int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
 
    		Animal animal= (Animal)getChild(groupPosition, childPosition);
        final String childText = animal.getName();
    	
 
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.activity_list_item, null);
        }
 
        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
 
        txtListChild.setText(childText);
        return convertView;
    }
 
    @Override
    public int getChildrenCount(int groupPosition) {
    	
    	if((animalChild.containsKey(animalHeader.get(groupPosition))==false)||
    	 (animalChild.get(this.animalHeader.get(groupPosition)).size()<2)){

    		return 0;
    	}
    	else
    		return this.animalChild.get(this.animalHeader.get(groupPosition))
                .size();
    		

			//return animalHeader.get(groupPosition).getType().size();
	
    }
 
    @Override
    public Object getGroup(int groupPosition) {
        return this.animalHeader.get(groupPosition);
        
        //return animalHeader.get(groupPosition);
    }
 
    @Override
    public int getGroupCount() {
        return this.animalHeader.size();
    	//return animalHeader.size();
    }
 
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
 
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
    	//String headerTitle =  animalHeader.get(groupPosition).getAnimalName();
    	 //  String headerTitle =  animalCategory[groupPosition].toString();
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.activity_list_group, null);
        }
 
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
 
        return convertView;
    }
 
    @Override
    public boolean hasStableIds() {
        return false;
    }
 
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
