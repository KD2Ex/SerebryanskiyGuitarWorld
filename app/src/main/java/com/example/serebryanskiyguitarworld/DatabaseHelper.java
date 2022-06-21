package com.example.serebryanskiyguitarworld;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "app.db";
    private static final int SCHEMA = 3;

    static final String USERS = "users";
    public static final String USERS_ID = "_id";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";

    static final String PRODUCTS = "products";
    public static final String PRODUCTS_ID = "_id";
    public static final String PRODUCTS_TITLE = "title";
    public static final String PRODUCTS_DESC = "description";
    public static final String PRODUCTS_IMAGE = "image";
    public static final String PRODUCTS_PRICE = "price";
    public static final String PRODUCTS_QUANTITY = "quantity";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS users (" + USERS_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + USERS_LOGIN + " TEXT,"
                + USERS_PASSWORD + " TEXT);");

        db.execSQL("INSERT INTO " + USERS + " (" + USERS_LOGIN + ", "
                + USERS_PASSWORD +") VALUES ('666', '666'), ('1', '1');");

        db.execSQL("CREATE TABLE IF NOT EXISTS products ("
                + PRODUCTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PRODUCTS_TITLE + " TEXT, "
                + PRODUCTS_DESC + " TEXT, "
                + PRODUCTS_PRICE + " INTEGER, "
                + PRODUCTS_IMAGE + " TEXT, "
                + PRODUCTS_QUANTITY + " INTEGER);");

        db.execSQL("INSERT OR IGNORE INTO "
                        + PRODUCTS
                        + "("
                        + PRODUCTS_TITLE + ", "
                        + PRODUCTS_DESC + ", "
                        + PRODUCTS_PRICE + ", "
                        + PRODUCTS_IMAGE + ", "
                        + PRODUCTS_QUANTITY + ")"
                        + " VALUES " +
                        "('Inspector', 'Electric guitar 6 string', 70000,'product1',2)," +
                        "('SolarA1.6', 'Electric guitar 6 string', 100000, 'product2', 3)," +
                        "('Jazz III XL Series', 'Picks, 1.38mm, 24pcs', 1700, 'product3', 4);"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + USERS);
        onCreate(db);
    }
}
