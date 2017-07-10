package com.example.marcel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v){
        EditText cal = (EditText) findViewById(R.id.cal);
        EditText sod = (EditText) findViewById(R.id.sod);
        EditText pot = (EditText) findViewById(R.id.pot);
        EditText pro = (EditText) findViewById(R.id.pro);
        EditText fib = (EditText) findViewById(R.id.fib);
        EditText gram = (EditText) findViewById(R.id.grams);

        double calories = Double.parseDouble(cal.getText().toString());
        double sodium = Double.parseDouble(sod.getText().toString());
        double potassium = Double.parseDouble(pot.getText().toString());
        double protein = Double.parseDouble(pro.getText().toString());
        double fiber = Double.parseDouble(fib.getText().toString());

        double grams = Double.parseDouble(gram.getText().toString());
    }

    public void update(View v){
        //when amount is changed, multiply values

    }
}
