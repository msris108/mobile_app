package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

public class UrlParser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_parser);

        findViewById(R.id.bt_url).setOnClickListener(view -> {
            EditText et = findViewById(R.id.et_url);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(et.getText().toString()));
            startActivity(intent);
        });
    }
}