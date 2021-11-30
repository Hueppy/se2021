package com.example.pfotenfreunde.ui.fragment.pet;

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


public class ListPetprofile extends Fragment {

    ListView simpleList;
    List<String> petList = new ArrayList<String>();
    EditText inputSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_petprofile, container,false);
        petList.add("Dog");
        petList.add("Cat");
        petList.add("Elephant");
        petList.add("Elephant");
        petList.add("Elephant");
        petList.add("Elephant");
        petList.add("Elephant");
        petList.add("Elephant");
        petList.add("Elephant");
        petList.add("Elephant");
        petList.add("Elephant");
        petList.add("Elephant");
        petList.add("Elephant");
        final ArrayAdapter<String> petAdapter = new ArrayAdapter<>(getActivity(),R.layout.entry_default,R.id.default_name,petList);
        simpleList = view.findViewById(R.id.pet_list);
        inputSearch = view.findViewById(R.id.pet_search);
        simpleList.setAdapter(petAdapter);
        simpleList.setOnItemClickListener((parent, view1, position, id) -> System.out.println(parent.getItemAtPosition(position)));
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                petAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }
}
