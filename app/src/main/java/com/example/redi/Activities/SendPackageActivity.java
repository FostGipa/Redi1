package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.redi.R;
import com.example.redi.databinding.ActivitySendPackageBinding;

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
    }
}