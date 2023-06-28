package com.example.oxycounter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "OxygenFlow";

    // Table columns
    public static final String ID = "Id";
    public static final String TYPE = "Type";
    public static final String COUNT = "Count";
    public static final String CATEGORY = "Category";
    public static final String ENTRY_DATE = "EntryDate";


    // Database Information
    static final String DB_NAME = "OxyCounter.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TYPE + " TEXT NOT NULL, " + COUNT + " TEXT ,"+CATEGORY+" TEXT ,"+ENTRY_DATE+" TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}