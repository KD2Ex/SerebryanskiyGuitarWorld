package com.example.serebryanskiyguitarworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorizaton);
        getSupportActionBar().setTitle("Guitar World");


        databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.create_db();
    }



    public void enter_onClick(View view) {


        EditText login = (EditText)findViewById(R.id.editTextLogin);
        EditText password = (EditText)findViewById(R.id.editTextPassword);

        db = databaseHelper.open();
        userCursor = db.rawQuery("select * from " + DatabaseHelper.USERS, null);

        while(userCursor.moveToNext()) {
            if (login.getText().toString().equals(userCursor.getString(1))
                && password.getText().toString().equals(userCursor.getString(2))) {
                Toast.makeText(this, "got it", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
            }
        }

        db.close();
        userCursor.close();


    }

    public void register_onClick(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

}