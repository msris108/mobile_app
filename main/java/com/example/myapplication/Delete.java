package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        EditText et_uname = findViewById(R.id.del_name);

        DBHelper dbHelper =  new DBHelper(getApplicationContext());

        Button del_btn = findViewById(R.id.btn_del);
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = et_uname.getText().toString();
                boolean res = dbHelper.delete(uname);
                if(res) Toast.makeText(getApplicationContext(), "Inserted!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "Not Inserted!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
