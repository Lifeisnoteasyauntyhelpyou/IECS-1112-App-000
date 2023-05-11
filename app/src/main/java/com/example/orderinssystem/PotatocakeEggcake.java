package com.example.orderinssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PotatocakeEggcake extends AppCompatActivity {

    private Button btPlus;
    private Button btMinus;
    private Button btSend;
    private TextView tvNumber;
    private CheckBox cbMayonnaise;
    private CheckBox cbCut;
    private boolean soySausce;
    private boolean crisp;
    private RadioGroup rgCheese;
    private RadioGroup rgVegetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_toast);

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

        cbMayonnaise = findViewById(R.id.cb_mayonnaise);
        cbMayonnaise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbMayonnaise.isChecked()){
                    soySausce = true;
                } else {
                    soySausce = false;
                }
            }
        });

        cbCut = findViewById(R.id.checkBox2);
        cbCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbMayonnaise.isChecked()){
                    crisp = true;
                } else {
                    crisp = false;
                }
            }
        });

        btSend = findViewById(R.id.bt_send);
        rgCheese = findViewById(R.id.radioGroup);
        rgVegetable = findViewById(R.id.radioGroup2);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cheese = rgCheese.getCheckedRadioButtonId();
                int vegetable = rgVegetable.getCheckedRadioButtonId();

                Intent intent = new Intent();
                intent.setClass(PotatocakeEggcake.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}