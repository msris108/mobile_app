package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class FinalGUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_gui);
        Bundle extras = getIntent().getExtras();
        Toast.makeText(getApplicationContext(), extras.getString("text"), Toast.LENGTH_SHORT).show();
    }
}