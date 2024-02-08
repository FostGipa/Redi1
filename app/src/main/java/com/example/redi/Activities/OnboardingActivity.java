package com.example.redi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.redi.Adapters.ViewPagerAdapter;
import com.example.redi.databinding.ActivityOnboardingBinding;

public class OnboardingActivity extends AppCompatActivity {

    ActivityOnboardingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences settings = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        binding.next.setOnClickListener(view -> {
            if (getItem(0) < 1) {
                binding.viewPager.setCurrentItem(getItem(1), true);
            }
            else {
                SharedPreferences.Editor prefEditor = settings.edit();
                prefEditor.putBoolean("FirstTime", false);
                prefEditor.apply();
                Intent intent = new Intent(OnboardingActivity.this, SignLogActivity.class);
                startActivity(intent);
            }
        });

        binding.skip.setOnClickListener(v -> {
            SharedPreferences.Editor prefEditor = settings.edit();
            prefEditor.putBoolean("FirstTime", false);
            prefEditor.apply();
            Intent intent = new Intent(OnboardingActivity.this, SignLogActivity.class);
            startActivity(intent);
        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(viewPagerAdapter);
    }

    private int getItem(int i) {
        return binding.viewPager.getCurrentItem() + i;
    }
}