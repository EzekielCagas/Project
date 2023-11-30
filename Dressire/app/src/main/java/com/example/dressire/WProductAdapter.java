package com.example.dressire;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class WProductAdapter extends RecyclerView.Adapter<WProductAdapter.ViewHolder> {
    private List<WProducts> products;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_wcoll, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WProducts product = products.get(position);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/dressire-2501f.appspot.com/o/WomenCollection%2Flavender.png?alt=media&token=e4ce74ab-8c06-4a47-8ff7-5e0a28665e64")
                .into(holder.imageView);
        holder.name.setText(product.getName());
        holder.price.setText(String.format(Locale.getDefault(), "₱%.2f", product.getPrice()));
        holder.ratingBar.setRating(product.getRating());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setData(List<WProducts> products){
        this.products = products;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView name;
        public TextView price;
        public RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            ratingBar = itemView.findViewById(R.id.rating);
        }
    }
}
