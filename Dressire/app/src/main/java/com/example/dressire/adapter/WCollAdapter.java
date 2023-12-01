package com.example.dressire.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dressire.Model.Womens;
import com.example.dressire.R;

import java.util.List;

public class WCollAdapter extends RecyclerView.Adapter<WCollAdapter.ViewHolder> {
    
    private List<Womens> womensList;
    
    @NonNull
    @Override
    public WCollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_wcoll, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WCollAdapter.ViewHolder holder, int position) {
        Womens womens = womensList.get(position);
        holder.productNameTextView.setText(womens.getName());
        holder.productPriceTextView.setText(String)
    }

    @Override
    public int getItemCount() {
        return womensList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView productNameTextView;
        public RecyclerView.ViewHolder(View itemView){
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
        }
    }
}
