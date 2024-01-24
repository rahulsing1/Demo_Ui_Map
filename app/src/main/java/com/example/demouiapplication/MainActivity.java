package com.example.demouiapplication;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import android.view.MenuItem;


import com.example.demouiapplication.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding binding;
    private boolean doubleBackPressed = false;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private Handler handler = new Handler(Looper.getMainLooper());
    private static final int BACK_PRESS_INTERVAL = 2000; // 2 seconds


    private Runnable resetBackPressedRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackPressed = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.setTitle("");
        setSupportActionBar(binding.toolbar);

        binding.navView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,binding.drawerLayout, binding.toolbar, R.string.open_nav, R.string.close_nav);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_home()).commit();
           binding.navView.setCheckedItem(R.id.nav_home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);

        } else if (itemId == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_settings()).commit();
        } else if (itemId == R.id.nav_share) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_share()).commit();
        } else if (itemId == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_about()).commit();
        } else if (itemId == R.id.nav_logout) {

            Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
        }

      binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if ( binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            if (doubleBackPressed) {
                super.onBackPressed();
                finishAffinity();
                finish();
                // Exit the app
            } else {
                doubleBackPressed = true;
                Toast.makeText(this, "Press back again to exit",
                        Toast.LENGTH_SHORT).show();

                handler.postDelayed(resetBackPressedRunnable,
                        BACK_PRESS_INTERVAL);

            }

        }
    }





}