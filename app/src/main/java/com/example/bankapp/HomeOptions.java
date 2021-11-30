package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.bankapp.opions_fragment.TransferFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeOptions extends AppCompatActivity {
    private BottomNavigationView nav_bar;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_options);


        nav_bar = findViewById(R.id.options_navbar);
        context = getApplicationContext();

        getSupportFragmentManager().beginTransaction().replace(R.id.options_fragment, new TransferFragment()).commit();



    }
}