package com.example.bankapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankapp.R;
import com.example.bankapp.objects.MoreObject;

import java.util.ArrayList;

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder> {
   private Context context;
   private ArrayList<MoreObject> arrayList;

    public MoreAdapter(Context context, ArrayList<MoreObject> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_options_1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoreObject list = arrayList.get(position);
        holder.name.setText(list.getName());
        list.setExpandable(false);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!list.isExpandable()){
                holder.back.setImageResource(R.drawable.ic_baseline_arrow_back);
                holder.layout.setVisibility(View.VISIBLE);
                list.setExpandable(!list.isExpandable());
                }else{
                    holder.back.setImageResource(R.drawable.ic_arrow_forward);
                    holder.layout.setVisibility(View.GONE);
                    list.setExpandable(!list.isExpandable());
                }
            }
        });

        ArrayList<String> options = list.getOptions();

        String op = options.get(0) + ", " + options.get(1) + ", " + options.get(2)+ ", " + options.get(3);
        holder.options.setText(op);
        NestedAdapter adapter = new NestedAdapter(options);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();
        holder.recyclerView.setAdapter(adapter);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,options;
        private ImageView back;
        private LinearLayout layout;
        private RecyclerView recyclerView;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.option_name);
            options = itemView.findViewById(R.id.option_list);
            back = itemView.findViewById(R.id.options_more);
            layout = itemView.findViewById(R.id.option_layout);
            recyclerView = itemView.findViewById(R.id.recycler_view_4);
            cardView = itemView.findViewById(R.id.card_opions);
        }
    }
}
