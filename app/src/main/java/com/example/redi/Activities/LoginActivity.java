package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.example.redi.CustomTextWatcher;
import com.example.redi.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText[] editText = {binding.loginEmailEditText, binding.loginPasswordEditText};
        CustomTextWatcher textWatcher = new CustomTextWatcher(editText, binding.loginButton);
        for (EditText ed1 : editText) {
            ed1.addTextChangedListener(textWatcher);
        }

        binding.loginSignupTextView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        binding.loginButton.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        binding.loginForgotTextView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }
}