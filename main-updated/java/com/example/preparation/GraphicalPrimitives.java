package com.example.preparation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GraphicalPrimitives extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphical_primitives);

        ImageView imageView = findViewById(R.id.imageView);
        Bitmap background = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        imageView.setBackground(new BitmapDrawable(getApplicationContext().getResources(), background));
        Canvas canvas = new Canvas(background);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);

        //To draw a Rectangle
        canvas.drawText("Rectangle", 420, 150, paint);
        canvas.drawRect(400, 200, 650, 700, paint);
        //To draw a Circle
        canvas.drawText("Circle", 120, 150, paint);
        canvas.drawCircle(200, 350, 150, paint);
        //To draw a Arc
        canvas.drawText("Arc", 120, 800, paint);
        canvas.drawArc(50, 850, 350, 1150, 135, 180, true, paint);
        //To draw a Line
        canvas.drawText("Line", 480, 800, paint);
        canvas.drawLine(520, 850, 520, 1150, paint);

        findViewById(R.id.button_anim).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Animation.class)));

        Bitmap bm = Bitmap.createBitmap(720, 1080, Bitmap.Config.ARGB_8888);
    }
}