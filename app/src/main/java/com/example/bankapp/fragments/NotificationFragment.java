package com.example.bankapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bankapp.R;
import com.example.bankapp.adapters.MoreAdapter;
import com.example.bankapp.objects.MoreObject;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<MoreObject> arrayList;
    private MoreAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_3);
        arrayList = new ArrayList<>();

        ArrayList<String> list = new ArrayList<>();
        list.add("option_1");
        list.add("option_2");
        list.add("option_3");
        list.add("option_4");
        list.add("option_5");

        arrayList.add(new MoreObject("OPTION ONE",list));
        arrayList.add(new MoreObject("OPTION TWO",list));
        arrayList.add(new MoreObject("OPTION THREE",list));
        arrayList.add(new MoreObject("OPTION FOUR",list));
        arrayList.add(new MoreObject("OPTION FVE",list));
        arrayList.add(new MoreObject("OPTION SIX",list));
        arrayList.add(new MoreObject("OPTION SEVEN",list));
        arrayList.add(new MoreObject("OPTION EIGTH",list));
        arrayList.add(new MoreObject("OPTION NINE",list));
        arrayList.add(new MoreObject("OPTION TEN",list));
        arrayList.add(new MoreObject("OPTION ELEVEN",list));
        arrayList.add(new MoreObject("OPTION TWELVE",list));


        recyclerView.hasFixedSize();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MoreAdapter(getContext(),arrayList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        return view;
    }
}