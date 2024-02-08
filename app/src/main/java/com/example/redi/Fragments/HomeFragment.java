package com.example.redi.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.redi.Activities.MainActivity;
import com.example.redi.Activities.SendPackageActivity;
import com.example.redi.R;
import com.example.redi.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);

        binding.homeSendPackage.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SendPackageActivity.class);
            startActivity(intent);
        });
        return binding.getRoot();
    }
}