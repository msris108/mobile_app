package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        findViewById(R.id.btn_delete).setOnClickListener(view -> dbHelper.delete("msris108@duck.com"));
    }
}