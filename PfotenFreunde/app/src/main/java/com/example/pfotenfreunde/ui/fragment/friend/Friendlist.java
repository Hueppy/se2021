package com.example.pfotenfreunde.ui.fragment.friend;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pfotenfreunde.R;

import java.util.ArrayList;
import java.util.List;

public class Friendlist extends Fragment {
    ListView friendList;
    List<String> friends = new ArrayList<String>();
    EditText inputSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        final ArrayAdapter<String> friendAdapter = new ArrayAdapter<>(getActivity(),R.layout.entry_default,R.id.default_name,friends);
        friends.add("Peter");
        friends.add("Dieter");
        friends.add("Sido");
        friends.add("Udo");

        friendList = view.findViewById(R.id.friend_list);
        inputSearch = view.findViewById(R.id.friend_list_search);

        friendList.setAdapter(friendAdapter);
        friendList.setOnItemClickListener((parent, view1, position, id) -> System.out.println(parent.getItemAtPosition(position)));
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                friendAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

}
