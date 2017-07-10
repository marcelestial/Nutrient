package com.example.marcel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean locked;
    double calg, sodg, potg, prog, fibg;
    EditText calBox, sodBox, potBox, proBox, fibBox, gramBox;
    TextWatcher watcher;

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

        //assign a textwatcher to the amount field
        watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable == gramBox.getEditableText() && locked)
                    update();
            }
        };

        gramBox.addTextChangedListener(watcher);

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
        if(grams > 0) {
            calg = calories / grams;
            sodg = sodium / grams;
            potg = potassium / grams;
            prog = protein / grams;
            fibg = fiber / grams;
        }
    }

    public void update(){
        //when amount is changed, multiply values
        double newGrams = 0;

        if(!gramBox.getText().toString().equals("")) {
            newGrams = Double.parseDouble(gramBox.getText().toString());
        }

        calBox.setText("" + (calg * newGrams));
        sodBox.setText("" + (sodg * newGrams));
        potBox.setText("" + (potg * newGrams));
        proBox.setText("" + (prog * newGrams));
        fibBox.setText("" + (fibg * newGrams));
    }
}
