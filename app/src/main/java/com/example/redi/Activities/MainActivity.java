package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.example.redi.Fragments.HomeFragment;
import com.example.redi.Fragments.ProfileFragment;
import com.example.redi.Fragments.TrackFragment;
import com.example.redi.Fragments.WalletFragment;
import com.example.redi.R;
import com.example.redi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setSelectedItemId(R.id.navigationHomeItem);
        HomeFragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.navigation_container, fragment).commit();

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigationHomeItem) {
                HomeFragment homefragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.navigation_container, homefragment).commit();
                return true;
            } else if (item.getItemId() == R.id.navigationWalletItem) {
                WalletFragment walletFragment = new WalletFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.navigation_container, walletFragment).commit();
                return true;
            } else if (item.getItemId() == R.id.navigationTrackItem) {
                TrackFragment trackFragment = new TrackFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.navigation_container, trackFragment).commit();
                return true;
            } else if (item.getItemId() == R.id.navigationProfileItem) {
                ProfileFragment profileFragment = new ProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.navigation_container, profileFragment).commit();
                return true;
            }
            return false;
        });
    }
}