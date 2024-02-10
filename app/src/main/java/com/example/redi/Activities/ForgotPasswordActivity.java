package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.example.redi.CustomTextWatcher;
import com.example.redi.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    ActivityForgotPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.forgotSigninTextView.setOnClickListener(v -> {
            Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        EditText[] editText = {binding.forgotEmailEditText};
        CustomTextWatcher textWatcher = new CustomTextWatcher(editText, binding.forgotSendButton);
        for (EditText ed : editText) ed.addTextChangedListener(textWatcher);

        binding.forgotSendButton.setOnClickListener(v -> {
            Intent intent = new Intent(ForgotPasswordActivity.this, OTPActivity.class);
            startActivity(intent);
        });
    }
}