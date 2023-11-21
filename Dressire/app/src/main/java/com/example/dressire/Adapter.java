package com.example.dressire;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.VersionVH> {

    List<Descriptions>descriptionsList;

    public Adapter(List<Descriptions> descriptionsList) {
        this.descriptionsList = descriptionsList;
    }

    @NonNull
    @Override
    public VersionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards, parent, false);
        return new VersionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionVH holder, int position) {

        Descriptions descriptions = descriptionsList.get(position);
        holder.aboutTxt.setText(descriptions.getAbouts());
        holder.descriptionTxt.setText(descriptions.getDescription());


        boolean isExpandable = descriptionsList.get(position).isExapandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return descriptionsList.size();
    }

    public class VersionVH extends RecyclerView.ViewHolder {

        TextView aboutTxt, descriptionTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;
        public VersionVH(@NonNull View itemView) {
            super(itemView);

            aboutTxt = itemView.findViewById(R.id.abouts);
            descriptionTxt = itemView.findViewById(R.id.description);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Descriptions abouts = descriptionsList.get(getAdapterPosition());
                    abouts.setExapandable(!abouts.isExapandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
