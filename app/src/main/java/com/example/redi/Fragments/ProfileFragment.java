package com.example.redi.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.redi.R;
import com.example.redi.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    boolean balanceHidden;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater);

        balanceHidden = false;

        binding.profileBalanceHideButton.setOnClickListener(v -> {
            if (balanceHidden){
                binding.profileBalanceTextView.setText("500.60");
                binding.profileBalanceHideButton.setBackgroundResource(R.drawable.ic_eye_slash);
                balanceHidden = false;
            } else {
                binding.profileBalanceTextView.setText("**********");
                binding.profileBalanceHideButton.setBackgroundResource(R.drawable.ic_eye);
                balanceHidden = true;
            }
        });

        return binding.getRoot();
    }
}