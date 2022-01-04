package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), FormGUI.class)));
        findViewById(R.id.button2).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), GraphicalPrimitives.class)));
        findViewById(R.id.button3).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), LocationSDCardSMS.class)));
        findViewById(R.id.button4).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Calculator.class)));
        findViewById(R.id.button5).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), MultiThreading.class)));
        findViewById(R.id.button6).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), UrlParser.class)));
        findViewById(R.id.button7).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Database.class)));
        findViewById(R.id.button8).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), CalenderPicker.class)));

    }
}