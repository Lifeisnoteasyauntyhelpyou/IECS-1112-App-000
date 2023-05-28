package com.example.orderinssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SetMealA extends AppCompatActivity {

    private Button btPlus;
    private Button btMinus;
    private Button btSend;
    private TextView tvNumber;
    private boolean soySauce;
    private boolean ketchup;
    private CheckBox cbSoySauce;
    private CheckBox cbKetchup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_meal_a);

        btPlus = findViewById(R.id.bt_plus);
        btMinus = findViewById(R.id.bt_minus);
        tvNumber = findViewById(R.id.tv_number);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(tvNumber.getText().toString());

                switch (view.getId()){
                    case R.id.bt_plus:
                        number++;
                        break;
                    case R.id.bt_minus:
                        number--;
                        break;
                }

                tvNumber.setText(Integer.toString(number));
            }
        };

        btMinus.setOnClickListener(listener);
        btPlus.setOnClickListener(listener);

        cbSoySauce = findViewById(R.id.cb_mayonnaise);
        cbSoySauce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbSoySauce.isChecked()){
                    soySauce = true;
                } else {
                    soySauce = false;
                }
            }
        });

        cbKetchup = findViewById(R.id.checkBox1);
        cbKetchup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbKetchup.isChecked()){
                    ketchup = true;
                } else {
                    ketchup = false;
                }
            }
        });

        btSend = findViewById(R.id.bt_send);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SetMealA.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}