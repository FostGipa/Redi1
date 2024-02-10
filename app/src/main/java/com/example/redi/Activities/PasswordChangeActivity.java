package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.example.redi.CustomTextWatcher;
import com.example.redi.databinding.ActivityPasswordChangeBinding;

public class PasswordChangeActivity extends AppCompatActivity {

    ActivityPasswordChangeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasswordChangeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText[] editText = {binding.passwordChangePasswordEditText, binding.passwordChangeConfPasswordEditText};
        CustomTextWatcher textWatcher = new CustomTextWatcher(editText, binding.passwordChangeButton);
        for (EditText ed : editText) ed.addTextChangedListener(textWatcher);

        binding.passwordChangeButton.setOnClickListener(v -> {
            if (binding.passwordChangePasswordEditText.getText().toString().equals(binding.passwordChangeConfPasswordEditText.getText().toString())) {
                Intent intent = new Intent(PasswordChangeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else Toast.makeText(PasswordChangeActivity.this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
        });
    }
}