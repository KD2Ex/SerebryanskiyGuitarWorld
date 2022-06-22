package com.example.serebryanskiyguitarworld;


import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH;
    private static String DB_NAME = "app.db";
    private static final int SCHEMA = 8;

    static final String USERS = "users";
    public static final String USERS_ID = "_id";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";

    static final String PRODUCTS = "product";
    public static final String PRODUCTS_ID = "_id";
    public static final String PRODUCTS_TITLE = "title";
    public static final String PRODUCTS_DESC = "description";
    public static final String PRODUCTS_IMAGE = "image";
    public static final String PRODUCTS_PRICE = "price";
    public static final String PRODUCTS_QUANTITY = "quantity";
    public static final String PRODUCTS_CATEGORY_ID = "categoryId";


    private Context myContext;


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext = context;
        DB_PATH = context.getFilesDir().getPath() + DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {    }

    void create_db()/* throws IOException */{
        File file = new File(DB_PATH);
        if (!file.exists()) {
            try (InputStream myInput = myContext.getAssets().open(DB_NAME);
                OutputStream myOutput = new FileOutputStream(DB_PATH)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
            }
            catch (IOException ex) {
                Log.d("DatabaseHelper", ex.getMessage());
            }
        }
    }

    public SQLiteDatabase open() throws SQLException {
        return  SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);

    }
}
