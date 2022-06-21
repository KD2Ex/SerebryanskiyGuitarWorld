package com.example.serebryanskiyguitarworld;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;


import com.example.serebryanskiyguitarworld.adapter.CategoryAdapter;
import com.example.serebryanskiyguitarworld.adapter.HomeCategoryAdapter;
import com.example.serebryanskiyguitarworld.model.Category;
import com.example.serebryanskiyguitarworld.model.HomeCategory;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView homeCategoryRecycler;
    HomeCategoryAdapter homeCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Guitar World");


//        Toolbar mytoolbar = (Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(mytoolbar);



        List<HomeCategory> homeCategoryList = new ArrayList<>();
        homeCategoryList.add(new HomeCategory(1, "guitar_category", "Гитары"));
        homeCategoryList.add(new HomeCategory(2, "accs", "Акссесуары"));
        homeCategoryList.add(new HomeCategory(3, "strings", "Струны"));

        setHomeCategoryRecycler(homeCategoryList);

    }

    private void setHomeCategoryRecycler(List<HomeCategory> homeCategoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        homeCategoryRecycler = findViewById(R.id.categoriesRecycler);
        homeCategoryRecycler.setLayoutManager(layoutManager);

        homeCategoryAdapter = new HomeCategoryAdapter(this, homeCategoryList);
        homeCategoryRecycler.setAdapter(homeCategoryAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.);
    }*/

    public void onClick(View view) {
        Intent intent = new Intent(this, Catalog.class);
        startActivity(intent);
    }

    public Home getThis() {
        return this;
    }
}

/*
class Product extends androidx.appcompat.widget.AppCompatButton {

    public Product(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}*/
