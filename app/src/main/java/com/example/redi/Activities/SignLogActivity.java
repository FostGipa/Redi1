package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.redi.databinding.ActivitySignLogBinding;

public class SignLogActivity extends AppCompatActivity {

    ActivitySignLogBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignLogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signup.setOnClickListener(v -> {
            Intent intent = new Intent(SignLogActivity.this, SignupActivity.class);
            startActivity(intent);
        });
        binding.signin.setOnClickListener(v -> {
            Intent intent = new Intent(SignLogActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}