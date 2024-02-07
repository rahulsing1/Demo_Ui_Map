// searchmap.java
package com.example.demouiapplication.Apihelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.demouiapplication.Locationshow;
import com.example.demouiapplication.R;
import com.example.demouiapplication.databinding.ActivitySearchmapBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Searchmap extends AppCompatActivity implements OnMapReadyCallback, MyAdapter.OnItemClickListener {
    ActivitySearchmapBinding binding;

    ArrayList<LatLng> locationArrayList;
    private GoogleMap mMap;

    LatLng ahmedabad = new LatLng(23.033863, 72.585022);
    LatLng vadodara = new LatLng(22.310696, 73.192635);
    LatLng rajkot = new LatLng(22.3039, 70.8022);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchmapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(Searchmap.this);


        multipullocationstore();


        binding.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityname;
                cityname = binding.searchlocationet.getText().toString();

                ApiInteraface apiinterface = Retrofitclint.getRetrofitinstante().create(ApiInteraface.class);
                apiinterface.getcityname(cityname).enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {

                        Model model = response.body();
                        List<Model.Result> alluserList;
                        alluserList = model.results;

                        Log.d("TAG", "onResponse: " + alluserList.size());
                        Log.d("TAG", "onResponse: " + alluserList);

                        binding.recyclerview.setAdapter(new MyAdapter(Searchmap.this, alluserList, Searchmap.this::onItemClick));


                        Log.d("TAG", "onResponse: " + alluserList);
                        binding.recyclerview.setLayoutManager(new LinearLayoutManager(Searchmap.this));


                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.d("TAG", "onFailure: " + t.getMessage());

                    }
                });
            }
        });
    }

    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);


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

    private void multipullocationstore() {
        locationArrayList = new ArrayList<>();
//        locationArrayList.add(ahmedabad);
//
//        locationArrayList.add(rajkot);
    }

    @Override
    public void onItemClick(Model.Result item) {
        Toast.makeText(Searchmap.this, "Clicked on: " + item.name, Toast.LENGTH_SHORT).show();
        Toast.makeText(Searchmap.this, "Clicked on: " + item.name, Toast.LENGTH_SHORT).show();
        Toast.makeText(Searchmap.this, "Clicked on: " + item.longitude, Toast.LENGTH_SHORT).show();

        LatLng latLng = new LatLng(item.latitude, item.longitude);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(item.name);
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5));
        mMap.addMarker(markerOptions);


    }
}
