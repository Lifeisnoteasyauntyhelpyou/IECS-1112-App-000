package com.example.orderinssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SetMealC extends AppCompatActivity{

    private Button btPlus;
    private Button btMinus;
    private Button btSend;
    private TextView tvNumber;
    private boolean ketchup;
    private CheckBox cbKetchup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_meal_c);

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
                        if(number == 1) {
                            break;
                        }
                        number--;
                        break;
                }

                tvNumber.setText(Integer.toString(number));
            }
        };

        btMinus.setOnClickListener(listener);
        btPlus.setOnClickListener(listener);

        cbKetchup = findViewById(R.id.cb_ketchup);
        cbKetchup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ketchup = cbKetchup.isChecked();
            }
        });

        btSend = findViewById(R.id.bt_send);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SetMealC.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}