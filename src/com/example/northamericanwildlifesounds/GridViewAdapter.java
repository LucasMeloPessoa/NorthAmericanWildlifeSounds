package com.example.northamericanwildlifesounds;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {

    private List<Animal> items;
    private LayoutInflater inflater;

    public GridViewAdapter(Context context, List<Animal> data) {
        inflater = LayoutInflater.from(context);

        items=data;
        
        
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
  
    }

    @Override
    public long getItemId(int i) {
      //  return items.get(i).drawableId;
    	return items.get(i).getImageURL();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if(v == null) {
            v = inflater.inflate(R.layout.activity_square_image_view, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView)v.getTag(R.id.picture);
        name = (TextView)v.getTag(R.id.text);

       // Item item = (Item)getItem(i);
        Animal item=(Animal)getItem(i);
        picture.setImageResource(item.getImageURL());
        name.setText(item.getName());

        return v;
    }

   
}