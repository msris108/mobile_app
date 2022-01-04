package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // other functions
        Button clear = findViewById(R.id.clear);
        Button equals = findViewById(R.id.equals);

        // TextViews
        TextView expression = findViewById(R.id.expression);
        TextView result = findViewById(R.id.result);

        // clear
        clear.setOnClickListener(view -> {
            expression.setText("");
            result.setText("");
        });

        // equals
        equals.setOnClickListener(view -> {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
            double ans;

            try {
                ans = new DoubleEvaluator().evaluate(expression.getText().toString());
                result.setText(Double.toString(ans));
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "invalid input", Toast.LENGTH_SHORT).show();
            }
        });

        // numbers
        findViewById(R.id.num0).setOnClickListener(view -> expression.setText(expression.getText().toString() + "0"));
        findViewById(R.id.num1).setOnClickListener(view -> expression.setText(expression.getText().toString() + "1"));
        findViewById(R.id.num2).setOnClickListener(view -> expression.setText(expression.getText().toString() + "2"));
        findViewById(R.id.num3).setOnClickListener(view -> expression.setText(expression.getText().toString() + "3"));
        findViewById(R.id.num4).setOnClickListener(view -> expression.setText(expression.getText().toString() + "4"));
        findViewById(R.id.num5).setOnClickListener(view -> expression.setText(expression.getText().toString() + "5"));
        findViewById(R.id.num6).setOnClickListener(view -> expression.setText(expression.getText().toString() + "6"));
        findViewById(R.id.num7).setOnClickListener(view -> expression.setText(expression.getText().toString() + "7"));
        findViewById(R.id.num8).setOnClickListener(view -> expression.setText(expression.getText().toString() + "8"));
        findViewById(R.id.num9).setOnClickListener(view -> expression.setText(expression.getText().toString() + "9"));
        findViewById(R.id.num00).setOnClickListener(view -> expression.setText(expression.getText().toString() + "00"));

        // operator and symbols
        findViewById(R.id.add).setOnClickListener(view -> expression.setText(expression.getText().toString() + "+"));
        findViewById(R.id.subtract).setOnClickListener(view -> expression.setText(expression.getText().toString() + "-"));
        findViewById(R.id.multiply).setOnClickListener(view -> expression.setText(expression.getText().toString() + "*"));
        findViewById(R.id.divide).setOnClickListener(view -> expression.setText(expression.getText().toString() + "/"));
        findViewById(R.id.decimal).setOnClickListener(view -> expression.setText(expression.getText().toString() + "."));
        findViewById(R.id.rightP).setOnClickListener(view -> expression.setText(expression.getText().toString() + "("));
        findViewById(R.id.leftP).setOnClickListener(view -> expression.setText(expression.getText().toString() + ")"));
    }
}