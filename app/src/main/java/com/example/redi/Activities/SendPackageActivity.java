package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.redi.R;
import com.example.redi.databinding.ActivitySendPackageBinding;
import com.yandex.mapkit.MapKitFactory;

public class SendPackageActivity extends AppCompatActivity {

    ActivitySendPackageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendPackageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sendPackageBackButton.setOnClickListener(v -> {
            finish();
        });

        binding.sendPackageInstantButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, SendPackage2Activity.class);
            startActivity(intent);
        });
    }
}