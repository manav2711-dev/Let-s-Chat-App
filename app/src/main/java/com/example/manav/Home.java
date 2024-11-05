package com.example.manav;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;


import java.util.ArrayList;
import java.util.Arrays;


public class Home extends Fragment  {
    ArrayList personNames=new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"));


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    View view;
    ImageView imageView, imageView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_chats, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<listdata> listdata
                = Constants.getlistdata();

        listadapter itemAdapter = new listadapter(listdata);
        {


            RecyclerView recyclerView
                    = view.findViewById(R.id.recycleView);
            recyclerView.setLayoutManager(
                    new LinearLayoutManager(getContext()));

            // adapter instance is set to the
            // recyclerview to inflate the items.
            recyclerView.setAdapter((RecyclerView.Adapter) itemAdapter);

        }
//        listdata[] listdata = new listdata[]{
//                new listdata("Email", android.R.drawable.ic_dialog_email),
//                new listdata("Info", android.R.drawable.ic_dialog_info),
//                new listdata("Delete", android.R.drawable.ic_delete),
//                new listdata("Dialer", android.R.drawable.ic_dialog_dialer),
//                new listdata("Alert", android.R.drawable.ic_dialog_alert),
//                new listdata("Map", android.R.drawable.ic_dialog_map),
//                new listdata("Email", android.R.drawable.ic_dialog_email),
//                new listdata("Info", android.R.drawable.ic_dialog_info),
//                new listdata("Delete", android.R.drawable.ic_delete),
//                new listdata("Dialer", android.R.drawable.ic_dialog_dialer),
//                new listdata("Alert", android.R.drawable.ic_dialog_alert),
//                new listdata("Map", android.R.drawable.ic_dialog_map),
//        };
//
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
//        listadapter adapter = new listadapter(listdata);
//        recyclerView.setHasFixedSize(false);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(adapter);

    }
    }
