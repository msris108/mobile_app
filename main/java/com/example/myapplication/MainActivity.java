package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button7);
        Button button5 = findViewById(R.id.button6);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openActivity(4); }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openActivity(5); }
        });

    }

    public void openActivity(int choice) {
        if(choice == 1) {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
        else if(choice == 2) {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        }
        else if(choice == 3) {
            Intent intent = new Intent(this, MainActivity4.class);
            startActivity(intent);
        }
        else if(choice == 4) {
            Intent intent = new Intent(this, MainActivity5.class);
            startActivity(intent);
        }
        else if(choice == 5) {
            Intent intent = new Intent(this, MainActivity6.class);
            startActivity(intent);
        }
    }
}