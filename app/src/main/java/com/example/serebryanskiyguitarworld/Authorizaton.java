package com.example.serebryanskiyguitarworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class Authorizaton extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorizaton);

        getActionBar().setTitle("Guitar World");

/*        Button button = (Button)findViewById(R.id.buttonAuth);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Authorizaton.this, MainActivity.class);
                startActivity(intent);


            }
        });*/
    }



}