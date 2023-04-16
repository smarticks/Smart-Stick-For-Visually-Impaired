package com.example.samplecheckmap;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class location extends AppCompatActivity {
    TextView lat,longi,add;
    TextView btn;
    double loc_lat;
    double loc_long;
    String address;
    ImageView i;
    DatabaseReference reff;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        lat=(TextView) findViewById(R.id.lat);
        longi=(TextView) findViewById(R.id.longi);
        add=(TextView) findViewById(R.id.add);
        btn=(TextView) findViewById(R.id.button);
        i=(ImageView) findViewById(R.id.imageView2);

        reff= FirebaseDatabase.getInstance().getReference().child("gps");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                loc_lat=Double.valueOf(snapshot.child("lat").getValue().toString());
                loc_long=Double.valueOf(snapshot.child("long").getValue().toString());
                lat.setText(String.valueOf(loc_lat));
                longi.setText( String.valueOf(loc_long));
                Geocoder geocoder = new Geocoder(location.this, Locale.getDefault());
                List<Address> addresses = null;
                try {
                    addresses = geocoder.getFromLocation(loc_lat,loc_long,1);
                    address = addresses.get(0).getAddressLine(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }



                add.setText(address);


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("Latitude", loc_lat);
                i.putExtra("Longitude",loc_long);
                i.putExtra("Address",address);
                startActivity(i);
            }
        });

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("Latitude", loc_lat);
                i.putExtra("Longitude",loc_long);
                i.putExtra("Address",address);
                startActivity(i);
            }
        });
    }

}
