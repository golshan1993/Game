package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButtontic;
    private Button mButtonfour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setId();
        setListeners();
    }

    private void setListeners() {
        mButtontic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                TicFragment frag = new TicFragment();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, frag).commit();
            }
        });

        mButtonfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FourFragment frag = new FourFragment();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, frag).commit();
            }
        });
    }

    private void setId() {
        mButtontic = findViewById(R.id.btn_tic);
        mButtonfour = findViewById(R.id.btn_4);
    }


}