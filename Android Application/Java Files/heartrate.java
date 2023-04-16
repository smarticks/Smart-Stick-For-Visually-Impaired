package com.example.samplecheckmap;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class heartrate extends AppCompatActivity {
    TextView heartrate;
    String rate;
    DatabaseReference reff;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heartvalue);

        heartrate = (TextView)findViewById(R.id.selecthr);
        reff= FirebaseDatabase.getInstance().getReference().child("pulse ");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                rate=snapshot.child("heart rate").getValue().toString();

                heartrate.setText(rate);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
