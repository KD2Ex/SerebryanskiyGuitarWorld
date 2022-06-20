package com.example.serebryanskiyguitarworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.serebryanskiyguitarworld.R;
import com.example.serebryanskiyguitarworld.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
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
