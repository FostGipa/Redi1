

package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.redi.databinding.ActivitySendPackage2Binding;

public class SendPackage2Activity extends AppCompatActivity {

    ActivitySendPackage2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendPackage2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.makePaymentClickButton.setOnClickListener(v -> {
            Intent intent = new Intent(SendPackage2Activity.this, TransactionSuccessfulActivity.class);
            startActivity(intent);
            finish();
        });
    }
}