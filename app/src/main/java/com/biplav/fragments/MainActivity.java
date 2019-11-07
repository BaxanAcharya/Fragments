package com.biplav.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.biplav.fragments.fragments.FirstFragment;
import com.biplav.fragments.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    String display = "first";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (display.equals("first")) {
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.replace(R.id.lineraLayout, firstFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btn.setText("Load Second Fragment");
            display = "second";
        } else if (display.equals("second")) {
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace(R.id.lineraLayout, secondFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btn.setText("Load First Fragment");
            display = "first";
        }
    }
}
