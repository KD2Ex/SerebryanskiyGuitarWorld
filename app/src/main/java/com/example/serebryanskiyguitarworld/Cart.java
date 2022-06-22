package com.example.serebryanskiyguitarworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }

    public void onClick(View view) {

        Intent intent = new Intent(this, Catalog.class);
        startActivity(intent);

    }
}