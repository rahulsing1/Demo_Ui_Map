package com.example.demouiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.demouiapplication.databinding.ActivityAuthenticatorBinding;

public class authentication extends AppCompatActivity {
    ActivityAuthenticatorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= ActivityAuthenticatorBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

       binding.login.setOnClickListener(v -> {
           Intent intent=new Intent(authentication.this, Login.class);
           startActivity(intent);
       });




        binding.signIn.setOnClickListener(v -> {
            Intent intent=new Intent(authentication.this, Locationshow.class);
            startActivity(intent);

        });


    }
}