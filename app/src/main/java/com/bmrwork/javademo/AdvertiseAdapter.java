package com.bmrwork.javademo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

// AdvertiseAdapter.java
// AdvertiseAdapter.java
public class AdvertiseAdapter extends RecyclerView.Adapter<AdvertiseAdapter.AdvertiseViewHolder> {
    private List<AdvertiseEntity> advertiseList;
    private Context context;

    public AdvertiseAdapter(Context context, List<AdvertiseEntity> advertiseList) {
        this.context = context;
        this.advertiseList = advertiseList;
    }

    @NonNull
    @Override
    public AdvertiseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advertise, parent, false);
        return new AdvertiseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertiseViewHolder holder, int position) {
        AdvertiseEntity entity = advertiseList.get(position);
        holder.textView.setText(entity.getName());

        // Load image using Picasso
        Picasso.get()
                .load(entity.getThumbImage())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            if (entity.getAppLink() != null && !entity.getAppLink().isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(entity.getAppLink()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return advertiseList.size();
    }

    public void updateList(List<AdvertiseEntity> newList) {
        advertiseList = newList;
        notifyDataSetChanged();
    }

    static class AdvertiseViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public AdvertiseViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}