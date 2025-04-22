package com.andro.myfoodz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private List<MenuModel> menuList;


    public MenuAdapter(List<MenuModel> menuList) {
        this.menuList = menuList;
    }

    public void filterList(List<MenuModel> filteredList) {
        menuList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuModel menuModel = menuList.get(position);
        holder.menu_name.setText(menuModel.getMenu_name());
        holder.menu_price.setText("₹" + menuModel.getMenu_price());
        Glide.with(holder.itemView.getContext())
                .load(menuModel.getMenu_image())
                .placeholder(R.drawable.menu_pic2)
                .into(holder.menu_image);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView menu_image;
        TextView menu_name;
        TextView menu_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menu_image = itemView.findViewById(R.id.food_image);
            menu_name = itemView.findViewById(R.id.food_name);
            menu_price = itemView.findViewById(R.id.food_price);
        }
    }
}
