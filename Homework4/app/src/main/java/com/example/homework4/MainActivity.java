package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.example.homework4.fragment.Fragment_Info;
import com.example.homework4.fragment.Fragment_Main;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    FragmentTransaction fragmentTransaction;
    Fragment_Main left_pane;
    Fragment_Info right_pane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        fragmentTransaction = manager.beginTransaction();


        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            left_pane= new Fragment_Main();
            right_pane = new Fragment_Info();
            fragmentTransaction.replace(R.id.left_pane_land,left_pane);
            fragmentTransaction.replace(R.id.right_pane_land,right_pane);
        } else {
            // In Portrial
            left_pane= new Fragment_Main();
            fragmentTransaction.replace(R.id.left_pane_port,left_pane);
        }
        fragmentTransaction.commit();
    }

    public void openDetail(View view) {
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        startActivity(intent);
    }
}
