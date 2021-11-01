package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MyCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calculator);

        // numbers
        Button zero = findViewById(R.id.num0);
        Button one = findViewById(R.id.num1);
        Button two = findViewById(R.id.num2);
        Button three = findViewById(R.id.num3);
        Button four = findViewById(R.id.num4);
        Button five = findViewById(R.id.num5);
        Button six = findViewById(R.id.num6);
        Button seven = findViewById(R.id.num7);
        Button eight = findViewById(R.id.num8);
        Button nine = findViewById(R.id.num9);


        // operators
        Button add = findViewById(R.id.add);
        Button subtract = findViewById(R.id.subtract);
        Button multiply = findViewById(R.id.multiply);
        Button divide = findViewById(R.id.divide);

        // other functions
        Button clear = findViewById(R.id.clear);
        Button equals = findViewById(R.id.equals);

        // TextViews
        TextView expression = findViewById(R.id.expression);
        TextView result = findViewById(R.id.result);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "0");
            }
        });

        // clear
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText("");
                result.setText("");
            }
        });

        // equals
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

                double ans;

                try {
                    ans = (double) engine.eval(expression.getText().toString());
                    result.setText(Double.toString(ans));
                } catch (ScriptException e) {
                    Toast.makeText(MyCalculator.this, "invalid input", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // numbers and operators
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "4");
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "5");
            }
        });


        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "+");
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "-");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "*");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setText(expression.getText().toString() + "/");
            }
        });





    }
}