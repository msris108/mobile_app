package com.example.preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class FormGUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_gui);

        findViewById(R.id.button_form).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editTextTextPersonName);
                Spinner spinner = findViewById(R.id.spinner);
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                Intent intent = new Intent(getApplicationContext(), FinalGUI.class);
                intent.putExtra("text", editText.getText().toString() + "\n" + spinner.getSelectedItem().toString() + "\n" + radioButton.getText().toString());
                startActivity(intent);
            }
        });

    }
}