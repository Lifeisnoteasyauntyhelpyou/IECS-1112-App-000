package com.example.orderinssystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class ActivityActivity extends AppCompatActivity {
    List<DataClass> dataList = new ArrayList<>();
    private ArrayList<String> Title = new ArrayList<>();
    private ArrayList<String> Number = new ArrayList<>();
    private int price = 19;

    Button activitySend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        activitySend = (Button) findViewById(R.id.activity_send);

        CheckData();
        activitySend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    public void saveData(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();
        UploadData();
    }

    public void UploadData(){
        String title = "豬肉起司堡";
        String number = String.valueOf(1);
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

                    Toast.makeText(ActivityActivity.this, "Saved", Toast.LENGTH_LONG).show();
                    finish();
                }
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ActivityActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
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