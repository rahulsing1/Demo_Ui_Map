package com.example.demouiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.demouiapplication.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name = "rahul";


        binding.loginBtn.setOnClickListener(v -> {
            String edittext = binding.edittext1.getText().toString();
            if (edittext.equals(name)) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(Login.this, "Plese enter Valid user name", Toast.LENGTH_SHORT).show();
            }

        });


    }
}