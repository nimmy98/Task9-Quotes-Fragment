package com.example.nimmy.task9_quotes_fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridFragment gridFragment = new GridFragment();
        FragmentManager grid_fm = getSupportFragmentManager();
        FragmentTransaction grid_ft = grid_fm.beginTransaction();
        grid_ft.replace(R.id.main_linear, gridFragment);
        grid_ft.commit();
    }
}
