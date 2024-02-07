package com.example.demouiapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.demouiapplication.Apihelper.ApiInteraface;
import com.example.demouiapplication.Apihelper.Retrofitclint;
import com.example.demouiapplication.databinding.ActivityLocationshowBinding;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Locationshow extends AppCompatActivity implements OnMapReadyCallback {
    Location currentLocation;
    private GoogleMap mMap;
    LatLng ahmedabad = new LatLng(23.033863, 72.585022);
    LatLng vadodara = new LatLng(22.310696, 73.192635);
    LatLng rajkot = new LatLng(22.3039, 70.8022);
    ArrayList<LatLng> locationArrayList;
    ActivityLocationshowBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationshowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(Locationshow.this);



           multipullocationstore();
    }
    private void multipullocationstore() {
        locationArrayList = new ArrayList<>();
        locationArrayList.add(ahmedabad);
        locationArrayList.add(vadodara);
        locationArrayList.add(rajkot);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        LatLng latLng = new LatLng(21.170240, 72.831062);

        //for single only map showing
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("I am here!");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5));
        googleMap.addMarker(markerOptions);


        //for using circle draw
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(21.124857, 73.112610))
                .radius(10000)
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));

        //using for loop multipul marker show...
        for (int i = 0; i < locationArrayList.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList.get(i)));
        }
    }

}