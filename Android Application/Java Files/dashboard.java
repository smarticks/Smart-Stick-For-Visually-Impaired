package com.example.samplecheckmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class dashboard extends AppCompatActivity{
TextView heartrate;
String rate;
ImageView i,h;
DatabaseReference reff;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heartrate);

        i=(ImageView)findViewById(R.id.Image);
        h=(ImageView)findViewById(R.id.hr);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(dashboard.this, location.class);
                startActivity(intent);
            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(dashboard.this, heartrate.class);
                startActivity(intent);
            }
        });
    }


}
