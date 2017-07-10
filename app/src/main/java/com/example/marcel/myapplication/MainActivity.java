package com.example.marcel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean locked;
    double calg, sodg, potg, prog, fibg;
    EditText calBox, sodBox, potBox, proBox, fibBox, gramBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locked = false;

        calBox = (EditText) findViewById(R.id.cal);
        sodBox = (EditText) findViewById(R.id.sod);
        potBox = (EditText) findViewById(R.id.pot);
        proBox = (EditText) findViewById(R.id.pro);
        fibBox = (EditText) findViewById(R.id.fib);
        gramBox = (EditText) findViewById(R.id.grams);

    }

    public void calculate(View v){
        locked = true;

        //snarf values from edittexts
        double calories = Double.parseDouble(calBox.getText().toString());
        double sodium = Double.parseDouble(sodBox.getText().toString());
        double potassium = Double.parseDouble(potBox.getText().toString());
        double protein = Double.parseDouble(proBox.getText().toString());
        double fiber = Double.parseDouble(fibBox.getText().toString());

        double grams = Double.parseDouble(gramBox.getText().toString());

        //determine values per gram
        calg = calories / grams;
        sodg = sodium / grams;
        potg = potassium / grams;
        prog = protein / grams;
        fibg = fiber / grams;
    }

    public void update(View v){
        //when amount is changed, multiply values
        if(locked){
            double newGrams = Double.parseDouble(gramBox.getText().toString());

        }
    }
}
