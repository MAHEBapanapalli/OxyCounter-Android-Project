package com.example.oxycounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,new MainFragment(),"mainFragment")
                .commit();
    }

    public void onViewIncomesButtonClicked(View v){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new ViewIncomingFragment(),"viewIncomingFragment")
                .addToBackStack(null)
                .commit();
    }

    public void onViewExpensesButtonClicked(View v){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new ViewOutgoingFragment(),"viewOutgoingFragment")
                .addToBackStack(null)
                .commit();
    }

    public void onViewInAndOutButtonClicked(View v){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new ViewInAndOutFragment(),"viewInAndOutFragment")
                .addToBackStack(null)
                .commit();
    }

    public void onAddIncomeOrExpenseClicked(View v){
        Intent intent = new Intent(this, AddIncomingOrOutgoing.class);
        startActivity(intent);
    }

    public void onViewIncomesTodayButtonClicked(View v){
        Intent intent = new Intent(this, DisplayIncoming.class);
        startActivity(intent);
    }

    public void onViewIncomesWeeklyButtonClicked(View v){
        Intent intent = new Intent(this, DisplayIncoming.class);
        startActivity(intent);
    }

    public void onViewIncomesMonthlyButtonClicked(View v){
        Intent intent = new Intent(this, DisplayIncoming.class);
        startActivity(intent);
    }

    public void onViewExpensesTodayButtonClicked(View v){
        Intent intent = new Intent(this, DisplayOutgoing.class);
        startActivity(intent);
    }

    public void onViewExpensesWeeklyButtonClicked(View v){
        Intent intent = new Intent(this, DisplayOutgoing.class);
        startActivity(intent);
    }

    public void onViewExpensesMonthlyButtonClicked(View v){
        Intent intent = new Intent(this, DisplayOutgoing.class);
        startActivity(intent);
    }

    public void onViewInAndOutTodayButtonClicked(View v){
        Intent intent = new Intent(this, DisplayInAndOut.class);
        startActivity(intent);
    }

    public void onViewInAndOutWeeklyButtonClicked(View v){
        Intent intent = new Intent(this, DisplayInAndOut.class);
        startActivity(intent);
    }

    public void onViewInAndOutMonthlyButtonClicked(View v){
        Intent intent = new Intent(this, DisplayInAndOut.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() ==  R.id.settings){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("About Application");
            alertDialog.setMessage("OxyCounter APP version 1.0 Developed by Mahesh.B, Sindhu.J, Bharat.J and Sai Kiran.G");
            alertDialog.setIcon(android.R.drawable.ic_dialog_alert);

            alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            alertDialog.setNegativeButton(null, null);

            AlertDialog dialog = alertDialog.create();
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
