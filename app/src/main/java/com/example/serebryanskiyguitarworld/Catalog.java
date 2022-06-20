package com.example.serebryanskiyguitarworld;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.serebryanskiyguitarworld.adapter.CategoryAdapter;
import com.example.serebryanskiyguitarworld.model.Category;

import java.util.ArrayList;
import java.util.List;

public class Catalog extends AppCompatActivity {

    RecyclerView categoryRecycler;
    RecyclerView productsRecycler;
    CategoryAdapter categoryAdapter;

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
        setRecycler(categoryList);

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void setRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        productsRecycler = findViewById(R.id.products);
        productsRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        productsRecycler.setAdapter(categoryAdapter);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}