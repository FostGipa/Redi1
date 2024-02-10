package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.example.redi.CustomTextWatcher;
import com.example.redi.R;
import com.example.redi.SupabaseService;
import com.example.redi.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText[] edList = {binding.signupNameEditText, binding.signupPhoneEditText, binding.signupEmailEditText,
                binding.signupPasswordEditText, binding.signupConfPasEditText};
        CustomTextWatcher textWatcher = new CustomTextWatcher(edList, binding.signupButton);
        for (EditText editText : edList) {
            editText.addTextChangedListener(textWatcher);
        }

        binding.signupButton.setOnClickListener(v -> {
            if (!binding.signupPasswordEditText.getText().toString().equals(binding.signupConfPasEditText.getText().toString())) {
                binding.signupPasswordEditText.setBackgroundResource(R.drawable.sign_custom_error_edittext);
                binding.signupConfPasEditText.setBackgroundResource(R.drawable.sign_custom_error_edittext);
                Toast.makeText(SignupActivity.this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
            } else if (!binding.signupCheckBox.isChecked()) {
                Toast.makeText(SignupActivity.this, "Примите пользовательское соглашение", Toast.LENGTH_LONG).show();
            } else {
                binding.signupPasswordEditText.setBackgroundResource(R.drawable.sign_custom_edittext);
                binding.signupConfPasEditText.setBackgroundResource(R.drawable.sign_custom_edittext);

                SupabaseService supabaseService = new SupabaseService();
                String currentString = binding.signupNameEditText.getText().toString();
                String first_name = currentString.split(" ")[0];
                String last_name = currentString.split(" ")[1];
                supabaseService.signup(
                        getApplicationContext(),
                        binding.signupEmailEditText.getText().toString(),
                        binding.signupPasswordEditText.getText().toString(),
                        first_name,
                        last_name,
                        binding.signupPhoneEditText.getText().toString(),
                        "");

                supabaseService.getName(getApplicationContext());

                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.signupSigninTextView.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}