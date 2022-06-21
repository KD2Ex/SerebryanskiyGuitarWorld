package com.example.serebryanskiyguitarworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.serebryanskiyguitarworld.Catalog;
import com.example.serebryanskiyguitarworld.R;
import com.example.serebryanskiyguitarworld.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Product> products;
    List<Product> productsCopy = new ArrayList<>();

    public void filter(String text) {
        products.clear();
        if (text.isEmpty()) {
            products.addAll(productsCopy);
        }
        else {
            text = text.toLowerCase();
            for(Product item: productsCopy) {
                if (item.getTitle().toLowerCase().contains(text)) {
                    products.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void filterByCategory(int category) {
        products.clear();
        if (category == 0) {
            products.addAll(productsCopy);
        }
        else {

            for(Product item: productsCopy) {
                if (item.getCategory() == category) {
                    products.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
        //this.productsCopy = products;
        //productsCopy.clear();
        this.productsCopy.addAll(products);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItems = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductAdapter.ProductViewHolder(productItems);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {


        boolean isAvailable = products.get(position).isAvailable();
        holder.isAvailable.setText(isAvailable ? "Available" : "Not available");
        holder.isAvailable.setTextColor(isAvailable
                ? ContextCompat.getColor(context, R.color.teal_200)
                : ContextCompat.getColor(context, R.color.red));

        holder.productTitle.setText(products.get(position).getTitle());
        holder.productDesc.setText(products.get(position).getDescription());
        holder.productPrice.setText(String.valueOf(products.get(position).getPrice()) + "₽");

        int imageID = context.getResources().getIdentifier(products.get(position).getImage(), "drawable", context.getPackageName());

        holder.productImage.setImageResource(imageID);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), com.example.serebryanskiyguitarworld.Product.class);
                intent.putExtra("Title", holder.productTitle.getText());
                intent.putExtra("Desc", holder.productDesc.getText());
                intent.putExtra("Price", holder.productPrice.getText());
                intent.putExtra("Image", imageID);
                intent.putExtra("IsAvailable", holder.isAvailable.getText());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public static final class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productTitle;
        TextView productDesc;
        TextView productPrice;
        TextView isAvailable;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById((R.id.productImageView));
            productTitle = itemView.findViewById((R.id.textViewProductTitle));
            productDesc = itemView.findViewById((R.id.textViewProductDesc));
            productPrice = itemView.findViewById((R.id.textViewPrice));
            isAvailable = itemView.findViewById((R.id.textViewAvailable));

        }
    }
}
