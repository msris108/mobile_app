package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        EditText et_uname = findViewById(R.id.et_uname);

        EditText et_pass = findViewById(R.id.et_pass);

        DBHelper dbHelper =  new DBHelper(getApplicationContext());

        Button insert_btn = findViewById(R.id.insert_btn);
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = et_uname.getText().toString();
                String pass = et_pass.getText().toString();
                boolean res = dbHelper.insert(uname, pass);
                if(res) Toast.makeText(getApplicationContext(), "Inserted!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "Not Inserted!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}