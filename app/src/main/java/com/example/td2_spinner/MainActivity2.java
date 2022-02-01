package com.example.td2_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button go;
    TextView textNumber;
    Spinner spinner_number_base;
    Spinner spinner_pas;
    Integer number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner_pas = findViewById(R.id.spinner_left);
        spinner_number_base = findViewById(R.id.spinner_right);

        go = findViewById(R.id.change);

        spinner_pas.setOnItemSelectedListener(changePas);
        spinner_number_base.setOnItemSelectedListener(changeNumber);
        go.setOnClickListener(changePage);
    }

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
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private View.OnClickListener changePage = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(view.getContext(), MainActivity3.class);
            intent.putExtra("spiner_base", Integer.parseInt(spinner_number_base.getSelectedItem().toString())) ;
            intent.putExtra("spiner_increment", Integer.parseInt(spinner_pas.getSelectedItem().toString())) ;
            startActivity(intent);
        }
    };
}