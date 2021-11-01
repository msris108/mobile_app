package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button btn_insert = findViewById(R.id.btn_insert);
        Button btn_update = findViewById(R.id.btn_update);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_view = findViewById(R.id.btn_view);
        Button btn_view_all = findViewById(R.id.btn_view_all);

        btn_insert.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Insert.class)));
        btn_update.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Update.class)));
        btn_delete.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Delete.class)));
        btn_view.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ViewOne.class)));
        btn_view_all.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ViewAll.class)));
    }
}