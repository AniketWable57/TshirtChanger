package com.example.dummy;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TshirtAdapter extends RecyclerView.Adapter<TshirtAdapter.ViewHolder> {

    private final List<Integer> tshirtList;
    private final OnTshirtClickListener listener;

    public TshirtAdapter(List<Integer> tshirtList, OnTshirtClickListener listener) {
        this.tshirtList = tshirtList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tshirt, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resourceId = tshirtList.get(position);

        if (resourceId == 0) {
            holder.tshirtImage.setImageResource(R.drawable.none); // "None" icon for the option
        } else {
            holder.tshirtImage.setImageResource(resourceId); // T-shirt images
        }

        holder.itemView.setOnClickListener(v -> listener.onTshirtClick(resourceId));
    }

    @Override
    public int getItemCount() {
        return tshirtList.size();
    }

    public interface OnTshirtClickListener {
        void onTshirtClick(int resourceId);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView tshirtImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tshirtImage = itemView.findViewById(R.id.tshirtImage);
        }
    }
}

