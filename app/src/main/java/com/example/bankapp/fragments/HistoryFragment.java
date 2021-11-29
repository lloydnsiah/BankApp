package com.example.bankapp.fragments;

import static com.example.bankapp.R.color.black;
import static com.example.bankapp.R.color.blue;
import static com.example.bankapp.R.color.dark_blue;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bankapp.R;
import com.example.bankapp.adapters.HistoryAdapter;
import com.example.bankapp.objects.HistoryObject;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<HistoryObject> arrayList;
    private HistoryAdapter adapter;
    private TextView all_t,debit_t,credit_t;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_2);
        all_t = view.findViewById(R.id.history_all);
        debit_t = view.findViewById(R.id.history_deposit);
        credit_t = view.findViewById(R.id.history_withdrawal);
        arrayList = new ArrayList<>();

        debit_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all_t.setTextColor(v.getResources().getColor(R.color.white));
                all_t.setBackgroundColor(v.getResources().getColor(dark_blue));

            }
        });

        for (int i=0;i<20;i++){
            arrayList.add(new HistoryObject("Credit","Lloyd Nsiah","Gladys Afeatse","27/11/21",12.04));
            arrayList.add(new HistoryObject("Debit","Lloyd Nsiah","Gladys Afeatse","27/11/21",12.04));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HistoryAdapter(getActivity(),arrayList);
        recyclerView.setAdapter(adapter);


        return view;
    }




}