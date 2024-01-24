package com.example.demouiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.demouiapplication.databinding.ActivityBottomSheetDialogBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MapActivity extends AppCompatActivity {
    ActivityBottomSheetDialogBinding binding;
    Button btn;
    TextView edt;
    BottomSheetDialog dialog;
    Location currentLocation;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomSheetDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialog = new BottomSheetDialog(MapActivity.this, R.style.CustomBottomSheetDialogTheme);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.row_add_item_new);
        dialog.show();
        binding.openbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new BottomSheetDialog(MapActivity.this, R.style.CustomBottomSheetDialogTheme);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.row_add_item_new);
                dialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dialog.dismiss();
    }
}