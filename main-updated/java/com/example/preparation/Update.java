package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        findViewById(R.id.btn_update).setOnClickListener(view -> dbHelper.update("sriram", "1234567890", "msris108@duck.com", "msris108 house"));
    }
}