package com.example.samplecheckmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class login extends AppCompatActivity{
    EditText username;
    EditText password;
    TextView signuptxt;
    Button loginButton;
    String log_user;
    String log_pass;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signuptxt = findViewById(R.id.signupText);
        reff= FirebaseDatabase.getInstance().getReference().child("login").child("login");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                log_user=snapshot.child("username").getValue().toString();
                log_pass=snapshot.child("password").getValue().toString();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().equals(log_user) && password.getText().toString().equals(log_pass)) {
                    Toast.makeText(login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), dashboard.class);
                    startActivity(i);
                } else {
                    Toast.makeText(login.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signuptxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });
    }

}
