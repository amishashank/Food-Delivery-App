package com.andro.myfoodz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CorouselAdapter extends RecyclerView.Adapter<CorouselAdapter.ViewHolder> {
    private List<CorouselModel> list;

    public CorouselAdapter(List<CorouselModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.corousel_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CorouselModel model = list.get(position);
        holder.banner_imageView.setImageResource(model.getBannerimages());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView banner_imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner_imageView = itemView.findViewById(R.id.banner_image);
        }
    }
}
