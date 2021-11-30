package com.example.pfotenfreunde.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pfotenfreunde.R;
import com.example.pfotenfreunde.model.friend.FriendRequest;
import com.example.pfotenfreunde.model.user.User;

import java.util.List;

public class FriendlistAdapter extends CustomAdapter<User> {
    public FriendlistAdapter(Context context, List<User> objectList) {
        super(context, objectList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(super.getContext()).inflate(R.layout.fragment_friend,parent,false);
        }
        FriendRequest current = (FriendRequest) getItem(position);

        TextView username = convertView.findViewById(R.id.default_name);
        ImageView rqPic = convertView.findViewById(R.id.default_pic);

        return convertView;
    }
}
