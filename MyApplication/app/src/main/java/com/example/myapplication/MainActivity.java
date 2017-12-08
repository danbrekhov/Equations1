package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LinearEquationActivity.class);
            startActivity(intent);
        });

        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuadraticEquationActivity.class);
            startActivity(intent);
        });

    }


    void initView(){
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
    }
}
