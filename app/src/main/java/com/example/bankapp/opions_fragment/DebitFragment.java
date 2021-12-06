package com.example.bankapp.opions_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bankapp.R;
import com.example.bankapp.adapters.DebitOptionsAdapter;
import com.example.bankapp.objects.DebitOptions;

import java.util.ArrayList;

public class DebitFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<DebitOptions> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_debit, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_5);
        arrayList = new ArrayList<>();

        arrayList.add(new DebitOptions("Object 1",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 2",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 3",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 4",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 5",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 6",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 7",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 8",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 1",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 2",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 3",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 4",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 5",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 6",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 7",R.drawable.ic_launcher_background));
        arrayList.add(new DebitOptions("Object 8",R.drawable.ic_launcher_background));



        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        DebitOptionsAdapter adapter = new DebitOptionsAdapter(getActivity(),arrayList);
        recyclerView.setAdapter(adapter);


        return view;
    }
}