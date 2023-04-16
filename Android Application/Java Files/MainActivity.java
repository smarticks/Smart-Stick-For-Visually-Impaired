package com.example.samplecheckmap;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    DatabaseReference reff;
    double lat;
    double longi;
    String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        lat = extras.getDouble("Latitude");
        longi = extras.getDouble("Longitude");
        address=extras.getString("Address");

        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {


        map=googleMap;

        LatLng loc=new LatLng(lat,longi);
        map.addMarker(new MarkerOptions().position(loc).title(address));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(loc,15f));

    }
}