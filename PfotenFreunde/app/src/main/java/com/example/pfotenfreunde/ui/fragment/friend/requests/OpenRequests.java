package com.example.pfotenfreunde.ui.fragment.friend.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pfotenfreunde.R;

import java.util.ArrayList;
import java.util.List;

public class OpenRequests extends Fragment {
    ListView requestList;
    List<String> requests = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_open_friend_request, container, false);
        final ArrayAdapter<String> friendAdapter = new ArrayAdapter<>(getActivity(),R.layout.entry_friend_request,R.id.request_user_name,requests);
        requests.add("Peter");
        requests.add("Dieter");
        requests.add("Sido");
        requests.add("Udo");

        requestList = view.findViewById(R.id.friend_requests_list);
        requestList.setAdapter(friendAdapter);
        requestList.setOnItemClickListener((parent, view1, position, id) -> System.out.println(parent.getItemAtPosition(position)));
        return view;
    }
}
