package com.example.pfotenfreunde.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class CustomAdapter<T> extends BaseAdapter {

    private final Context context;
    private final List<T> objectList;

    public CustomAdapter(Context context, List<T> objectList) {
        this.context = context;
        this.objectList = objectList;
    }

    @Override
    public int getCount() {
        return objectList.size();
    }

    @Override
    public Object getItem(int position) {
        return objectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public Context getContext() {
        return context;
    }

}
