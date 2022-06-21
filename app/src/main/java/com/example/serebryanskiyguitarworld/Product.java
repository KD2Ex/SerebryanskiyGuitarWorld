package com.example.serebryanskiyguitarworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            TextView title = (TextView) findViewById(R.id.textViewTitle);
            TextView desc = (TextView) findViewById(R.id.textViewDescription);
            TextView price = (TextView) findViewById(R.id.textViewPrice);
            //TextView isInStock = (TextView) findViewById(R.id.textView);
            ImageView image = (ImageView) findViewById(R.id.imageViewProduct);


            title.setText(extras.getString("Title"));
            desc.setText(extras.getString("Desc"));
            price.setText(extras.getString("Price"));
            image.setImageResource(extras.getInt("Image"));


        }
    }

    public void onClick(View view) {
        Toast.makeText(this, "Товар добален в корзину", Toast.LENGTH_SHORT).show();

    }

}