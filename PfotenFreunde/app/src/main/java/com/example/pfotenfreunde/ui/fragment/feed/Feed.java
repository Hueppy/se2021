package com.example.pfotenfreunde.ui.fragment.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.example.pfotenfreunde.R;

import java.util.ArrayList;
import java.util.List;

public class Feed extends Fragment {


    ListView feed;
    List<String> posts = new ArrayList<String>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container,false);
        final ArrayAdapter<String> friendAdapter = new ArrayAdapter<>(getActivity(),R.layout.entry_feed,R.id.post_username, posts);
        posts.add("Peter");
        posts.add("Dieter");
        posts.add("Sido");
        posts.add("Udo");

        feed = view.findViewById(R.id.feed_list);
        feed.setAdapter(friendAdapter);

        return view;
    }
}
