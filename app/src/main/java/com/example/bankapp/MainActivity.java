package com.example.bankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.bankapp.fragments.HistoryFragment;
import com.example.bankapp.fragments.HomeFragment;
import com.example.bankapp.fragments.NotificationFragment;
import com.example.bankapp.fragments.ProfileFragment;
import com.example.bankapp.fragments.QRFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView nav_bar;
    private Context context;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_bar = findViewById(R.id.nav_view);
        fab = findViewById(R.id.fab);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new HomeFragment()).commit();

        nav_bar.setSelectedItemId(R.id.menuHome);

        nav_bar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.menuHome:
                        fragment = new HomeFragment();
                        break;
                    case R.id.menuHistory:
                        fragment = new HistoryFragment();
                        break;
                    case R.id.menuNotification:
                        fragment = new NotificationFragment();
                        break;
                    case R.id.menuProfile:
                        fragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment,fragment).commit();

                return true;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new QRFragment()).commit();
            }
        });




    }
}