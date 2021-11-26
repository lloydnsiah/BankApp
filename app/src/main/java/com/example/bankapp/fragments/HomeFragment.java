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
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankapp.R;
import com.example.bankapp.adapters.InfoAdapter;
import com.example.bankapp.objects.InfoObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private LinearLayout linear_1;
    private ArrayList<InfoObject> arrayList;
    private RecyclerView recyclerView;
    private InfoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_1);
        arrayList = new ArrayList<>();
        arrayList.add(new InfoObject("Amazing Offers from our Bank this November","this month our bank is providing its customers with amazing discounts"));
        arrayList.add(new InfoObject("Amazing Offers from our Bank this December","this month our bank is providing its customers with amazing discounts"));
        arrayList.add(new InfoObject("Amazing Offers from our Bank this January","this month our bank is providing its customers with amazing discounts"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new InfoAdapter(getActivity(),arrayList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);



        return view;
    }
}