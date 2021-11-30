package com.example.pfotenfreunde.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pfotenfreunde.R;
import com.example.pfotenfreunde.adapter.CustomAdapter;
import com.example.pfotenfreunde.model.friend.FriendRequest;

import java.util.List;

public class FriendrequestAdapter extends CustomAdapter<FriendRequest> {

    public FriendrequestAdapter(Context context, List<FriendRequest> objectList) {
        super(context, objectList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(super.getContext()).inflate(R.layout.fragment_open_friend_request,parent,false);
        }
        FriendRequest current = (FriendRequest) getItem(position);

        TextView rqUser = convertView.findViewById(R.id.request_user_name);
        TextView rqDate = convertView.findViewById(R.id.request_date);
        ImageView rqPic = convertView.findViewById(R.id.request_profil_pic);

        rqUser.setText(current.getSender().getName());
        rqDate.setText(current.getSendAt().toString());

        return convertView;

    }
}
