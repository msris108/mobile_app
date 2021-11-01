package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        DBHelper dbHelper = new DBHelper(this);
        Cursor res = dbHelper.ViewAll();

        TextView tv = findViewById(R.id.all_res);

        if(res.getCount() <= 0) {

        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            while(res.moveToNext()) {
                stringBuilder.append("Name:").append(res.getString(0)).append("\n");
                stringBuilder.append("Pass:").append(res.getString(1)).append("\n\n");
            }
            tv.setText(stringBuilder);

        }
    }
}