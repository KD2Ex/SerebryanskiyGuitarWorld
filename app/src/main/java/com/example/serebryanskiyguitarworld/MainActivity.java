package com.example.serebryanskiyguitarworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorizaton);
        getSupportActionBar().setTitle("Guitar World");
    }



    public void enter_onClick(View view) {
        Intent intent = new Intent(this, Home.class);

        EditText login = (EditText)findViewById(R.id.editTextLogin);
        EditText password = (EditText)findViewById(R.id.editTextPassword);
        if (login.getText().toString().equals("w") &&
            password.getText().toString().equals("w")) {
            Toast.makeText(this, login.getText(), Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
    }

    public void register_onClick(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

}