package com.example.oxycounter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayOutgoing extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase database;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_outgoing);
        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        String qry = "SELECT * FROM " + DatabaseHelper.TABLE_NAME  + " where Type = '" + "Outgoing" + "'";

        TextView tableData = findViewById(R.id.display_ougoing_textview);

        Cursor c = database.rawQuery(qry, null);

        tableData.setText("    Type      "+"     Count      "+"   Category"+"\n");
        tableData.append("--------------"+"        "+"------------"+"       "+"------------------"+"\n");

        for(int i = 0; i < c.getCount();i++){
            c.moveToNext();

            String type = c.getString(1);
            String Count = c.getString(2);
            String Category = c.getString(3);
            tableData.append(type+"        "+Count+"              "+Category+"\n");
        }
    }
}