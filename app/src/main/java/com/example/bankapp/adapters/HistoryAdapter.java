package com.example.bankapp.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankapp.R;
import com.example.bankapp.objects.HistoryObject;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Activity activity;
    private ArrayList<HistoryObject> arrayList;

    public HistoryAdapter(Activity activity, ArrayList<HistoryObject> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType ==1){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_2_debit,parent,false);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_2_credit,parent,false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.from.setText(arrayList.get(position).getFrom());
        holder.to.setText(arrayList.get(position).getTo());
        holder.date.setText(arrayList.get(position).getDate());
        holder.amount.setText(String.valueOf(arrayList.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        String type = arrayList.get(position).getType();
        if (type.equals("Debit")){
            return 1;
        }else{
            return 2;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView from,to,date,amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            from = itemView.findViewById(R.id.records_from);
            to = itemView.findViewById(R.id.records_to);
            date = itemView.findViewById(R.id.records_date);
            amount = itemView.findViewById(R.id.records_amount);

        }
    }
}
