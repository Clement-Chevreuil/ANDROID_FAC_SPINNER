package com.example.td2_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_moins;
    Button btn_plus;
    TextView textNumber;
    Spinner spinner_number_base;
    Spinner spinner_pas;
    Integer number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_moins = findViewById(R.id.btn_spinner_left);
        btn_plus = findViewById(R.id.btn_spinner_right);

        spinner_pas = findViewById(R.id.spinner_left);
        spinner_number_base = findViewById(R.id.spinner_right);

        textNumber = findViewById(R.id.number);

        btn_moins.setOnClickListener(actionMoins);
        btn_plus.setOnClickListener(actionPlus);

        spinner_pas.setOnItemSelectedListener(changePas);
        spinner_number_base.setOnItemSelectedListener(changeNumber);


       number = Integer.parseInt(spinner_number_base.getSelectedItem().toString());
       textNumber.setText(number.toString());

    }

    private View.OnClickListener actionMoins = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer spinner_number_increment = Integer.parseInt(spinner_pas.getSelectedItem().toString());
            number = number - spinner_number_increment;
            textNumber.setText(number.toString());
        }
    };

    private View.OnClickListener actionPlus = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer spinner_number_increment = Integer.parseInt(spinner_pas.getSelectedItem().toString());
            number = number + spinner_number_increment;
            textNumber.setText(number.toString());
        }
    };

    private AdapterView.OnItemSelectedListener changePas = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            spinner_pas.setOnItemSelectedListener(this);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private AdapterView.OnItemSelectedListener changeNumber = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            spinner_number_base.setOnItemSelectedListener(this);
            number = Integer.parseInt(spinner_number_base.getSelectedItem().toString());
            textNumber.setText(spinner_number_base.getSelectedItem().toString());

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


}