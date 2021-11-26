package com.example.bankapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bankapp.R;
import com.example.bankapp.adapters.InfoAdapter;
import com.example.bankapp.objects.InfoObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<InfoObject> arrayList;
    private Context context;
    private InfoAdapter adapter;
    private LinearLayout linear_trans;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        linear_trans = view.findViewById(R.id.linear_transfer);
        arrayList = new ArrayList<>();
        context = getActivity();

        linear_trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Working", Toast.LENGTH_SHORT).show();
            }
        });
        for (int i = 0;i<5;i++){
            arrayList.add(new InfoObject("Amazing Offers from our Bank this December","this month our bank is providing its customers with amazing discounts"));
        }

        recyclerView = view.findViewById(R.id.recycler_view_1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        adapter = new InfoAdapter(context,arrayList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        return view;
    }
}