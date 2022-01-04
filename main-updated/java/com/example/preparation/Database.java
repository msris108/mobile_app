package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Database extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        findViewById(R.id.bt_insert).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Insert.class)));
        findViewById(R.id.bt_delete).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Delete.class)));
        findViewById(R.id.bt_update).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Update.class)));
        findViewById(R.id.bt_view).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ViewAll.class)));
    }
}