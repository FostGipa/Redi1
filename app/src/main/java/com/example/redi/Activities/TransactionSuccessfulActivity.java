package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.example.redi.databinding.ActivityTransactionSuccessfulBinding;

public class TransactionSuccessfulActivity extends AppCompatActivity {

    ActivityTransactionSuccessfulBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTransactionSuccessfulBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(() -> {
            binding.progressBar.setVisibility(View.GONE);
            binding.imageView.setVisibility(View.VISIBLE);
        }, 3000);

        binding.homepageBackButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}