package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.CustomTextWatcher;
import com.example.redi.R;
import com.example.redi.databinding.ActivityOtpactivityBinding;

public class OTPActivity extends AppCompatActivity {

    ActivityOtpactivityBinding binding;
    private boolean resendEnable = false;
    private final int resendTime = 60;
    private int OTPCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.otpEditText1.addTextChangedListener(textWatcher);
        binding.otpEditText2.addTextChangedListener(textWatcher);
        binding.otpEditText3.addTextChangedListener(textWatcher);
        binding.otpEditText4.addTextChangedListener(textWatcher);
        binding.otpEditText5.addTextChangedListener(textWatcher);
        binding.otpEditText6.addTextChangedListener(textWatcher);

        showKeyboard(binding.otpEditText1);
        startCountDown();

        EditText[] editText = {binding.otpEditText1, binding.otpEditText2, binding.otpEditText3, binding.otpEditText4, binding.otpEditText5, binding.otpEditText6};
        CustomTextWatcher textWatcher1 = new CustomTextWatcher(editText, binding.otpSetNewButton);
        for (EditText ed : editText) ed.addTextChangedListener(textWatcher1);

        binding.otpSetNewButton.setOnClickListener(v -> {
            Intent intent = new Intent(OTPActivity.this, PasswordChangeActivity.class);
            startActivity(intent);
        });

        binding.otpResendTextView.setOnClickListener(v -> {
            if (resendEnable) {
                Toast.makeText(OTPActivity.this, "Код отправлен", Toast.LENGTH_LONG).show();
            }
        });
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() > 0) {
                if (OTPCount == 0) {
                    OTPCount = 1;
                    binding.otpEditText1.setBackgroundResource(R.drawable.otp_custom_text_bg);
                    showKeyboard(binding.otpEditText2);
                } else if (OTPCount == 1) {
                    OTPCount = 2;
                    binding.otpEditText2.setBackgroundResource(R.drawable.otp_custom_text_bg);
                    showKeyboard(binding.otpEditText3);
                } else if (OTPCount == 2) {
                    OTPCount = 3;
                    binding.otpEditText3.setBackgroundResource(R.drawable.otp_custom_text_bg);
                    showKeyboard(binding.otpEditText4);
                } else if (OTPCount == 3) {
                    OTPCount = 4;
                    binding.otpEditText4.setBackgroundResource(R.drawable.otp_custom_text_bg);
                    showKeyboard(binding.otpEditText5);
                } else if (OTPCount == 4) {
                    OTPCount = 5;
                    binding.otpEditText5.setBackgroundResource(R.drawable.otp_custom_text_bg);
                    showKeyboard(binding.otpEditText6);
                } else if (OTPCount == 5) {
                    binding.otpEditText6.setBackgroundResource(R.drawable.otp_custom_text_bg);
                }
            }
        }
    };

    private void showKeyboard(EditText ed) {
        ed.requestFocus();

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(ed, InputMethodManager.SHOW_IMPLICIT);
    }

    private void startCountDown() {
        new CountDownTimer(resendTime * 1000L, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                binding.otpResendTextView.setText(" resend after " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                binding.otpResendTextView.setText("resend");
                binding.otpResendTextView.setTextColor(Color.parseColor("#0560FA"));
                resendEnable = true;
            }
        }.start();
    }
}