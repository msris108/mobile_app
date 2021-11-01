package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity6 extends AppCompatActivity {
    private TextView banner, coord, counter_text, banner2;

    private Button counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        banner = (TextView) findViewById(R.id.banner);
        banner2 = (TextView) findViewById(R.id.banner2);

        counter_text = (TextView) findViewById(R.id.counter);
        coord = (TextView) findViewById(R.id.coord);
        counter = (Button) findViewById(R.id.button);

        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = Integer.parseInt(counter_text.getText().toString());
                current++;
                counter_text.setText(String.valueOf(current));
            }});



        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            banner.animate().translationXBy(400f);
                            coord.animate().translationXBy(400f);
                            int[] location = new int[2];
                            banner.getLocationOnScreen(location);
                            coord.setText("Location: (" + location[0] + ", " + location[1] + ")");
                            Random random = new Random();
                            int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                            banner.setTextColor(color);

                            // banner.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.purple_700));

                        }
                    });
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Random random = new Random();
                            int clr1 = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                            int clr2 = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                            banner2.setBackgroundColor(clr1);
                            banner2.setTextColor(clr2);
                        }
                    });
                }
            }
        }).start();
    }
}