package com.example.orderinssystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PorkToast extends AppCompatActivity {
  List<DataClass> dataList = new ArrayList<>();
  private ArrayList<String> Title = new ArrayList<>();
  private ArrayList<String> Number = new ArrayList<>();
  private int price = 100;

  private Button btPlus;
  private Button btMinus;
  private Button btSend;
  private TextView tvNumber;
  private CheckBox cbMayonnaise;
  private CheckBox cbCut;
  private boolean mayonnaise;
  private boolean cut;
  private RadioGroup rgCheese;
  private RadioGroup rgVegetable;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pork_toast);

    btPlus = findViewById(R.id.bt_plus);
    btMinus = findViewById(R.id.bt_minus);
    tvNumber = findViewById(R.id.tv_number);
    CheckData();

    View.OnClickListener listener = new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int number = Integer.parseInt(tvNumber.getText().toString());

        switch (view.getId()){
          case R.id.bt_plus:
            number++;
            break;
          case R.id.bt_minus:
            if(number == 1){
              number = 1;
            } else{
              number--;
            }
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
          mayonnaise = true;
        } else {
          mayonnaise = false;
        }
      }
    });

    cbCut = findViewById(R.id.checkBox2);
    cbCut.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (cbMayonnaise.isChecked()){
          cut = true;
        } else {
          cut = false;
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

        saveData();
      }
    });
  }
  public void saveData(){
    AlertDialog.Builder builder = new AlertDialog.Builder(PorkToast.this);
    builder.setCancelable(false);
    builder.setView(R.layout.progress_layout);
    AlertDialog dialog = builder.create();
    dialog.show();
    UploadData();
  }

  public void UploadData(){
    String title = "里肌吐司";
    String number = tvNumber.getText().toString();
    String money = String.valueOf(Integer.parseInt(number)*price);

    for(int i = 0;i<Title.size();i++){
      if(Title.get(i).equals(title)){
        number = String.valueOf(Integer.parseInt(number) + Integer.parseInt(Number.get(i)));
        money = String.valueOf(Integer.parseInt(number)*price);
        break;
      }
    }

    DataClass dataClass = new DataClass(title, money, number);

    FirebaseDatabase.getInstance().getReference("Android Tutorials").child(title).setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
      @Override
      public void onComplete(@NonNull Task<Void> task) {
        if(task.isSuccessful()){

          Toast.makeText(PorkToast.this, "Saved", Toast.LENGTH_LONG).show();
          finish();
        }
      }

    }).addOnFailureListener(new OnFailureListener() {
      @Override
      public void onFailure(@NonNull Exception e) {
        Toast.makeText(PorkToast.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
      }
    });
  }

  public void CheckData(){
    //判斷一樣
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Android Tutorials");
    databaseReference.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot snapshot) {
        dataList.clear();
        for(DataSnapshot itemSnapshot: snapshot.getChildren()){
          DataClass dataClass = itemSnapshot.getValue(DataClass.class);
          dataList.add(dataClass);

          Title.add(dataClass.getDataTitle());
          Number.add(dataClass.getDataNumber());
        }
      }

      @Override
      public void onCancelled(@NonNull DatabaseError error) {

      }
    });
  }

}