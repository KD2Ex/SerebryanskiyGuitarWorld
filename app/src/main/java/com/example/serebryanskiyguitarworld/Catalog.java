package com.example.serebryanskiyguitarworld;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.serebryanskiyguitarworld.adapter.CategoryAdapter;
import com.example.serebryanskiyguitarworld.adapter.ProductAdapter;
import com.example.serebryanskiyguitarworld.model.Category;
import com.example.serebryanskiyguitarworld.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Catalog extends AppCompatActivity {

    RecyclerView categoryRecycler;
    RecyclerView productRecycler;
    CategoryAdapter categoryAdapter;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Каталог");

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Гитары"));
        categoryList.add(new Category(2, "Струны"));
        categoryList.add(new Category(3, "Медиатор"));
        categoryList.add(new Category(4, "Чехлы"));
        categoryList.add(new Category(5, "Прочее"));
        categoryList.add(new Category(6, "Уход"));


        setCategoryRecycler(categoryList);


        List<Product> products = new ArrayList<>();
        products.add(new Product(1, 70000,
                "Inspector", "Electric guita\n6 string",
                "product1", true));

        products.add(new Product(2, 100000,
                "Solar A1.6", "Electric guitar\n6 string",
                "product2", false));

        products.add(new Product(3, 70000,
                "Jazz III XL Series", "Guitar pick 1.38mm",
                "product3", true));

        products.add(new Product(4, 70000,
                "Daddario 10-46", "Strings for electric gutiar",
                "product4", false));

        products.add(new Product(5, 70000,
                "Описание", "Название",
                "product5", true));

        products.add(new Product(6, 70000,
                "Описание", "Название",
                "accs", true));

        products.add(new Product(7, 70000,
                "Название", "описание",
                "guitar_category", true));

        setProductRecycler(products);

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void setProductRecycler(List<Product> products) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        productRecycler = findViewById(R.id.products);
        productRecycler.setLayoutManager(layoutManager);

        productAdapter = new ProductAdapter(this, products);
        productRecycler.setAdapter(productAdapter);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}