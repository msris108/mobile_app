package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        ImageView i = findViewById(R.id.imageView);
        i.setBackground(new BitmapDrawable(getApplicationContext().getResources(), bg));
        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);
        //To draw a Rectangle
        canvas.drawText("Rectangle", 420, 150, paint);
        canvas.drawRect(400, 200, 650, 700, paint);
        //To draw a Circle
        canvas.drawText("Circle", 120, 150, paint);
        canvas.drawCircle(200, 350, 150, paint);
        //To draw a Square
        canvas.drawText("Square", 120, 800, paint);
        canvas.drawRect(50, 850, 350, 1150, paint);
        //To draw a Line
        canvas.drawText("Line", 480, 800, paint);
        canvas.drawLine(520, 850, 520, 1150, paint);

        Button animate = findViewById(R.id.animate_obj);
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAnimation();
            }
        });
    }

    private void openAnimation() {
        Intent intent = new Intent(this, Animation.class);
        startActivity(intent);
    }
}