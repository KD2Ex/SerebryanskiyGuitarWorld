package com.example.serebryanskiyguitarworld;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Guitar World");

        databaseHelper = new DatabaseHelper(getApplicationContext());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    public void onClick(View view) {

        EditText login = (EditText)findViewById(R.id.login);
        EditText password = (EditText)findViewById(R.id.password);


        if(!login.getText().toString().equals("") && 
            !password.getText().toString().equals("")) {

            db = databaseHelper.open();

            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.USERS_LOGIN, login.getText().toString());
            contentValues.put(DatabaseHelper.USERS_PASSWORD, password.getText().toString());

            db.insert(DatabaseHelper.USERS, null, contentValues);

            Toast.makeText(this, "Вы успешно зарегистрированы", Toast.LENGTH_SHORT).show();
            finish();

            db.close();
            
        }
    }
}