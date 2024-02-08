package com.example.redi.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.models.TransactionHistoryModel;
import com.example.redi.R;

import java.util.List;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder> {

    Context context;
    List<TransactionHistoryModel> list;

    public TransactionHistoryAdapter(Context context, List<TransactionHistoryModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TransactionHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.transaction_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHistoryAdapter.ViewHolder holder, int position) {
        holder.sum.setText(list.get(position).getSum());
        holder.client.setText(list.get(position).getClient());
        holder.date.setText(list.get(position).getDate());
        if (list.get(position).getTransaction_type() == "Снятие") {
            holder.sum.setTextColor(Color.parseColor("#ED3A3A"));
        } else {
            holder.sum.setTextColor(Color.parseColor("#35B369"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {

        TextView sum, client, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sum = itemView.findViewById(R.id.sumTextView);
            client = itemView.findViewById(R.id.clientTextView);
            date = itemView.findViewById(R.id.dateTextView);
        }
    }
}
