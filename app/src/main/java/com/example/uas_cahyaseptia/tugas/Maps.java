package com.example.uas_cahyaseptia.tugas;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.uas_cahyaseptia.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        maps = googleMap;

        LatLng Kampus = new LatLng(-6.3418857,106.7220551);
        maps.addMarker(new MarkerOptions().position(Kampus).title("Fantastic Home"));
        maps.setMaxZoomPreference(1000);
        maps.setMinZoomPreference(10);
        maps.moveCamera(CameraUpdateFactory.newLatLng(Kampus));

    }
}
