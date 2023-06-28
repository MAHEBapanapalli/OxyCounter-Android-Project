package com.example.oxycounter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DisplayInAndOut extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase database;
    ArrayList barEntries;
    BarChart barChart;
    BarDataSet barDataSet1, barDataSet2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_in_and_out);
        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();


        String incomeSum = "SELECT SUM(Count) FROM " + DatabaseHelper.TABLE_NAME + " where Type = '" + "Incoming" + "'";
        Cursor incomeCursor = database.rawQuery(incomeSum, null);

        String expenseSum = "SELECT SUM(Count) FROM " + DatabaseHelper.TABLE_NAME + " where Type = '" + "Outgoing" + "'";
        Cursor expenseCursor = database.rawQuery(expenseSum, null);


        BarChart barChart = findViewById(R.id.Barchart);
        barDataSet1 = new BarDataSet(getBarEntriesOne(), "Incoming");
        barDataSet1.setColor(getApplicationContext().getResources().getColor(R.color.purple_200));
        barDataSet2 = new BarDataSet(getBarEntriesTwo(), "Outgoing");
        barDataSet2.setColor(Color.BLUE);

        BarData data = new BarData(barDataSet1, barDataSet2);

        barChart.setData(data);

        barChart.getDescription().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();

        xAxis.setCenterAxisLabels(true);


        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);


        xAxis.setGranularity(1);

        xAxis.setGranularityEnabled(true);

        barChart.setDragEnabled(true);

        barChart.setVisibleXRangeMaximum(3);

        float barSpace = 0.1f;

        float groupSpace = 0.5f;

        data.setBarWidth(0.15f);


        barChart.getXAxis().setAxisMinimum(0);

        barChart.animate();


        barChart.groupBars(0, groupSpace, barSpace);


        barChart.invalidate();
    }

    // array list for first set
    private ArrayList<BarEntry> getBarEntriesOne() {

        barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1f, 12));
        barEntries.add(new BarEntry(2f, 14));
        barEntries.add(new BarEntry(3f, 6));
        barEntries.add(new BarEntry(4f, 13));
        barEntries.add(new BarEntry(5f, 23));
        barEntries.add(new BarEntry(6f, 11));
        return barEntries;
    }

    // array list for second set.
    private ArrayList<BarEntry> getBarEntriesTwo() {

        barEntries = new ArrayList<>();


        barEntries.add(new BarEntry(1f, 6));
        barEntries.add(new BarEntry(2f, 8));
        barEntries.add(new BarEntry(3f, 4));
        barEntries.add(new BarEntry(4f, 11));
        barEntries.add(new BarEntry(5f, 18));
        barEntries.add(new BarEntry(6f, 7));
        return barEntries;
    }
}




