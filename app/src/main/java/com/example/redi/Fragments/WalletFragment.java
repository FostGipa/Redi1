package com.example.redi.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.redi.Adapters.TransactionHistoryAdapter;
import com.example.redi.R;
import com.example.redi.databinding.FragmentWalletBinding;
import com.example.myapplication.models.TransactionHistoryModel;

import java.util.ArrayList;
import java.util.List;

public class WalletFragment extends Fragment {

    FragmentWalletBinding binding;
    List<TransactionHistoryModel> transactionHistoryModelList= new ArrayList<>();

    public WalletFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWalletBinding.inflate(inflater);

        transactionHistoryModelList.add(new TransactionHistoryModel(1, "-N3,000.00", "Снятие", "Delivery fee", "July 7, 2022"));
        transactionHistoryModelList.add(new TransactionHistoryModel(2, "N2,000.00", "Пополнение", "Lalalalala", "July 7, 2022"));
        transactionHistoryModelList.add(new TransactionHistoryModel(3, "-N3,000.00", "Снятие", "Delivery fee", "July 7, 2022"));
        transactionHistoryModelList.add(new TransactionHistoryModel(4, "N2,000.00", "Пополнение", "Lalalalala", "July 7, 2022"));
        transactionHistoryModelList.add(new TransactionHistoryModel(5, "-N3,000.00", "Снятие", "Delivery fee", "July 7, 2022"));
        transactionHistoryModelList.add(new TransactionHistoryModel(6, "N2,000.00", "Пополнение", "Lalalalala", "July 7, 2022"));

        TransactionHistoryAdapter adapter = new TransactionHistoryAdapter(getContext(), transactionHistoryModelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.walletHistoryRecyclerView.setLayoutManager(layoutManager);
        binding.walletHistoryRecyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}