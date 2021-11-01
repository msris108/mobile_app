package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        ImageView i = findViewById(R.id.iv_animate);
        i.setBackground(new BitmapDrawable(getApplicationContext().getResources(), bg));
        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        //To draw a Rectangle
        canvas.drawRect(200, 200, 650, 700, paint);

        Button bt_zoom=findViewById(R.id.bt_zoom);
        Button bt_forward=findViewById(R.id.bt_forward);
        Button bt_backward=findViewById(R.id.bt_backward);
        Button bt_fade=findViewById(R.id.bt_fade);
        Button bt_rotate=findViewById(R.id.bt_rotate);

        final ImageView iv_animate=findViewById(R.id.iv_animate);

        bt_zoom.setOnClickListener(v -> iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in)));
        bt_fade.setOnClickListener(v -> iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in)));
        bt_rotate.setOnClickListener(v -> iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate)));
        bt_forward.setOnClickListener(v -> iv_animate.animate().translationXBy(300f).setDuration(600));
        bt_backward.setOnClickListener(v -> iv_animate.animate().translationXBy(-300f).setDuration(600));
    }
}