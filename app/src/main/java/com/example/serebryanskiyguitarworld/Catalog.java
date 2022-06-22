package com.example.serebryanskiyguitarworld;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

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

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;

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

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.create_db();
        db = databaseHelper.open();
        userCursor = db.rawQuery("select * from " + DatabaseHelper.PRODUCTS, null);

        List<Product> products = new ArrayList<>();

        while(userCursor.moveToNext()) {
            products.add(new Product(
                    userCursor.getInt(0),
                    userCursor.getString(1),
                    userCursor.getString(2),
                    userCursor.getInt(3),
                    userCursor.getString(4),
                    true,
                    1
            ));
        }

        db.close();
        userCursor.close();


        setProductRecycler(products);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                productAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                productAdapter.filter(newText);
                return true;
            }
        });

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

    public static void showProductsByCategory(int category) {

    }


    public void onClick (View view) {
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }


}