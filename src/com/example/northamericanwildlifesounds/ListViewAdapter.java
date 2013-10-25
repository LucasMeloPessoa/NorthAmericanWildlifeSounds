package com.example.northamericanwildlifesounds;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class ListViewAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public ListViewAdapter(Context context, int textViewResourceId,
        List<String> objects) {
      super(context, textViewResourceId, objects);
      for (int i = 0; i < objects.size(); ++i) {
        mIdMap.put(objects.get(i), i);
      }
    }

    
    
    
    public void changeData(List<String> objects) {
       HashMap<String, Integer> newdata = new HashMap<String, Integer>();
          for (int i = 0; i < objects.size(); ++i) {
            newdata.put(objects.get(i), i);
          }
          
          mIdMap=newdata;
          notifyDataSetChanged();
        }
    
    
    @Override
    public long getItemId(int position) {
      String item = getItem(position);
      return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
      return true;
    }

  }