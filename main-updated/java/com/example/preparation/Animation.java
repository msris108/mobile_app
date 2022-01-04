package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        Button bt_forward=findViewById(R.id.bt_forward);
        Button bt_backward=findViewById(R.id.bt_backward);
        Button bt_zoom=findViewById(R.id.bt_zoom);
        Button bt_fade=findViewById(R.id.bt_fade);
        Button bt_rotate=findViewById(R.id.bt_rotate);

        ImageView iv_animate=findViewById(R.id.iv_animate);

        bt_rotate.setOnClickListener(view -> iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate)));
        bt_fade.setOnClickListener(view -> iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in)));
        bt_zoom.setOnClickListener(v -> iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in)));
        bt_forward.setOnClickListener(v -> iv_animate.animate().translationXBy(300f).setDuration(600));
        bt_backward.setOnClickListener(v -> iv_animate.animate().translationXBy(-300f).setDuration(600));
    }
}