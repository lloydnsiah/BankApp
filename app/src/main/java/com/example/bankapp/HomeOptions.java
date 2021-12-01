package com.example.bankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bankapp.fragments.HistoryFragment;
import com.example.bankapp.fragments.HomeFragment;
import com.example.bankapp.fragments.NotificationFragment;
import com.example.bankapp.fragments.ProfileFragment;
import com.example.bankapp.opions_fragment.CommenceFragment;
import com.example.bankapp.opions_fragment.DebitFragment;
import com.example.bankapp.opions_fragment.TransferFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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

        nav_bar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.options_transfer:
                        fragment = new TransferFragment();
                        break;
                    case R.id.options_debit:
                        fragment = new DebitFragment();
                        break;
                    case R.id.options_commence:
                        fragment = new CommenceFragment();
                        break;
                    case R.id.options_flazz:
                        fragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment,fragment).commit();

                return true;
            }
        });
    }
}