package com.example.bankapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankapp.HomeOptions;
import com.example.bankapp.R;
import com.example.bankapp.adapters.InfoAdapter;
import com.example.bankapp.objects.InfoObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<InfoObject> arrayList;
    private InfoAdapter adapter;
    private LinearLayout linear_1;
    private ImageButton image_1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        linear_1 = view.findViewById(R.id.linear_1);
        image_1 = view.findViewById(R.id.image_1);


        image_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HomeOptions.class));
            }
        });

        linear_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Working", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}