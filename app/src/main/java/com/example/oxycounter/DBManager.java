package com.example.oxycounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String type, String count,String category) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String date = sdf.format(new Date());

        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.TYPE, type);
        contentValue.put(DatabaseHelper.COUNT, count);
        contentValue.put(DatabaseHelper.CATEGORY, category);
        contentValue.put(DatabaseHelper.ENTRY_DATE, date);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public List<OxygenFlow> getAll() {

        List<OxygenFlow> list = new ArrayList<>();

        String[] columns = new String[] { DatabaseHelper.ID, DatabaseHelper.TYPE,DatabaseHelper.COUNT, DatabaseHelper.CATEGORY,DatabaseHelper.ENTRY_DATE };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null  && cursor.getCount()>0) {

            OxygenFlow oxygenFlow = new OxygenFlow();

            do{
                cursor.moveToFirst();

                oxygenFlow.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.ID)));
                oxygenFlow.setType(cursor.getString(cursor.getColumnIndex(DatabaseHelper.TYPE)));
                oxygenFlow.setCatogery(cursor.getString(cursor.getColumnIndex(DatabaseHelper.CATEGORY)));
                oxygenFlow.setCount(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COUNT)));
                oxygenFlow.setDate(cursor.getString(cursor.getColumnIndex(DatabaseHelper.ENTRY_DATE)));

                list.add(oxygenFlow);

            }while (cursor.moveToNext());
        }
        return list;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.ID + "=" + _id, null);
    }
}
