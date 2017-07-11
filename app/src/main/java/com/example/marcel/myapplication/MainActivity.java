package com.example.marcel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    final double OZTOG = 28.3495;
    boolean saved;
    //boolean units determines which units of measurement for amount (true=oz, false=g)
    boolean units;
    double calg, sodg, potg, prog, fibg;
    EditText calBox, sodBox, potBox, proBox, fibBox, amountBox;
    TextWatcher watcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //values per unit are not saved yet
        saved = false;

        //create the spinner for units of measurement
        Spinner units = (Spinner) findViewById(R.id.unit_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.units, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //apply adapter to spinner
        units.setAdapter(adapter);
        //set spinner listener
        units.setOnItemSelectedListener(this);

        //instantiate text fields
        calBox = (EditText) findViewById(R.id.cal);
        sodBox = (EditText) findViewById(R.id.sod);
        potBox = (EditText) findViewById(R.id.pot);
        proBox = (EditText) findViewById(R.id.pro);
        fibBox = (EditText) findViewById(R.id.fib);
        amountBox = (EditText) findViewById(R.id.grams);

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
                if (editable == amountBox.getEditableText() && saved)
                    update();
            }
        };

        amountBox.addTextChangedListener(watcher);

    }

    public void calculate(View v){
        //values per unit have been calculated
        saved = true;

        //snarf values from edittexts
        double calories = Double.parseDouble(calBox.getText().toString());
        double sodium = Double.parseDouble(sodBox.getText().toString());
        double potassium = Double.parseDouble(potBox.getText().toString());
        double protein = Double.parseDouble(proBox.getText().toString());
        double fiber = Double.parseDouble(fibBox.getText().toString());

        double grams = Double.parseDouble(amountBox.getText().toString());

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

        if(!amountBox.getText().toString().equals("")) {
            newGrams = Double.parseDouble(amountBox.getText().toString());
            if(units){
                newGrams /= OZTOG;
            }
        }

        calBox.setText("" + (calg * newGrams));
        sodBox.setText("" + (sodg * newGrams));
        potBox.setText("" + (potg * newGrams));
        proBox.setText("" + (prog * newGrams));
        fibBox.setText("" + (fibg * newGrams));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if(!amountBox.getText().toString().equals(""))
        if(pos == 0){
            units = false;
            double oz = Double.parseDouble(amountBox.getText().toString());
            amountBox.setText("" + (oz / OZTOG));
        }
        else{
            units = true;
            double g = Double.parseDouble(amountBox.getText().toString());
            amountBox.setText("" + (g * OZTOG));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        units = false;
    }
}
