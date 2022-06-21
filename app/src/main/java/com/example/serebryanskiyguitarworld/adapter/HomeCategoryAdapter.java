package com.example.serebryanskiyguitarworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.serebryanskiyguitarworld.Authorizaton;
import com.example.serebryanskiyguitarworld.Catalog;
import com.example.serebryanskiyguitarworld.Home;
import com.example.serebryanskiyguitarworld.R;
import com.example.serebryanskiyguitarworld.model.HomeCategory;

import java.util.List;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.HomeCategoryViewHolder> {

    Context context;
    List<HomeCategory> homeCategories;

    public HomeCategoryAdapter(Context context, List<HomeCategory> homeCategories) {
        this.context = context;
        this.homeCategories = homeCategories;
    }

    @NonNull
    @Override
    public HomeCategoryAdapter.HomeCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View homeCategoryItems = LayoutInflater.from(context).inflate(R.layout.home_category_item, parent, false);
        return new HomeCategoryAdapter.HomeCategoryViewHolder(homeCategoryItems);

    }

    @Override
    public void onBindViewHolder(@NonNull HomeCategoryAdapter.HomeCategoryViewHolder holder, int position) {

        int imageId  = context.getResources().getIdentifier(homeCategories.get(position).getImg(), "drawable", context.getPackageName());

        holder.homeCategoryImage.setImageResource(imageId);
        holder.homeCategoryTitle.setText(homeCategories.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), Catalog.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeCategories.size();
    }

    public static final class HomeCategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView homeCategoryImage;
        TextView homeCategoryTitle;

        public HomeCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            homeCategoryImage = itemView.findViewById(R.id.homeCategoryImage);
            homeCategoryTitle = itemView.findViewById(R.id.homeCategoryTitle);
        }
    }
}
