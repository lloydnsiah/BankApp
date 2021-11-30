package com.example.bankapp.opions_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankapp.R;

public class TransferFragment extends Fragment {
    private TextView bank_txt,momo_txt;
    private LinearLayout momo_layout,bank_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transfer, container, false);

        bank_txt = view.findViewById(R.id.bank_txt);
        momo_txt = view.findViewById(R.id.momo_txt);
        momo_layout = view.findViewById(R.id.momo_layout);
        bank_layout = view.findViewById(R.id.bank_layout);

        bank_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                momo_layout.setVisibility(View.GONE);
                bank_layout.setVisibility(View.VISIBLE);
            }
        });

        momo_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                momo_layout.setVisibility(View.VISIBLE);
                bank_layout.setVisibility(View.GONE);
            }
        });



        return view;
    }
}