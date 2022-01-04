package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        findViewById(R.id.btn_insert).setOnClickListener(view -> dbHelper.insert("sriram", "9123456789", "msris108@duck.com", "msris108 house"));
    }
}