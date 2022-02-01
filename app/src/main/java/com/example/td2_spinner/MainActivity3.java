package com.example.td2_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView number2;
    Button moins;
    Button plus;
    Button finish;
    Integer incrementNumber;
    Integer baseNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        number2 = findViewById(R.id.numbe);
        moins = findViewById(R.id.moins);
        plus = findViewById(R.id.plus);

        finish = findViewById(R.id.finish);

        moins.setOnClickListener(actionMoins);
        plus.setOnClickListener(actionPlus);
        finish.setOnClickListener(finishApp);

        baseNumber = this.getIntent().getExtras().getInt("spiner_base");
        incrementNumber = this.getIntent().getExtras().getInt("spiner_increment");
        number2.setText(baseNumber.toString());
    }

    private View.OnClickListener actionMoins = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            baseNumber = baseNumber - incrementNumber;
            number2.setText(baseNumber.toString());
        }
    };

    private View.OnClickListener actionPlus = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            baseNumber = baseNumber + incrementNumber;
            number2.setText(baseNumber.toString());
        }
    };

    private View.OnClickListener finishApp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}