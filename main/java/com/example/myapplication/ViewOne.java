package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_one);

        EditText et_uname = findViewById(R.id.view_uname);
        Button btn = findViewById(R.id.btn_view_one);
        TextView tv = findViewById(R.id.id_res_one);
        DBHelper dbHelper = new DBHelper(getApplicationContext());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = et_uname.getText().toString();
                Cursor res = dbHelper.ViewOne(uname);

                if(res.getCount() <= 0) {

                }
                else {
                    StringBuilder stringBuilder = new StringBuilder();
                    while(res.moveToNext()) {
                        stringBuilder.append("Name:").append(res.getString(0)).append("\n");
                        stringBuilder.append("Pass:").append(res.getString(1)).append("\n\n");
                        break;
                    }
                    tv.setText(stringBuilder);

                }
            }
        });


    }
}