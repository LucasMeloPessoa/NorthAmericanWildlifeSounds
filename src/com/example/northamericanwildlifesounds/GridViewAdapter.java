package com.example.northamericanwildlifesounds;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {

    private List<Animal> animals;
    private LayoutInflater inflater;

    public GridViewAdapter(Context context, List<Animal> data) {
        inflater = LayoutInflater.from(context);
        animals=data;
        
    }

    public int getCount() {
        return animals.size();
    }

    public Object getItem(int i) {
        return animals.get(i);
  
    }

    public long getItemId(int i) {
    	return animals.get(i).getImageURL();
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

        Animal animal=(Animal)getItem(i);
        picture.setImageResource(animal.getImageURL());
        name.setText(animal.getName());

        return v;
	}
}