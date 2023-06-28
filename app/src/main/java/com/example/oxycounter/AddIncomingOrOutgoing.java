package com.example.oxycounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddIncomingOrOutgoing extends AppCompatActivity {
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_incoming_or_outgoing);
        final Spinner type = (Spinner) findViewById(R.id.add_incoming_or_outgoing_type);
        final  Spinner category = (Spinner) findViewById(R.id.add_incoming_or_outgoing_category);

        ArrayAdapter<CharSequence> typeadapter = ArrayAdapter.createFromResource(this,
                R.array.type, android.R.layout.simple_spinner_item);
        typeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(typeadapter);

        ArrayAdapter<CharSequence> categoryadapter = ArrayAdapter.createFromResource(this,
                R.array.category, android.R.layout.simple_spinner_item);
        categoryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(categoryadapter);

        final EditText editText = findViewById(R.id.editText);

        dbManager = new DBManager(this);
        dbManager.open();

        Button addBtn = findViewById(R.id.button);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tpe = (String) type.getSelectedItem();
                String catg = (String) category.getSelectedItem();
                String count = editText.getText().toString();

                dbManager.insert(tpe,count,catg);
                if(tpe.equals("Outgoing")){
                    Toast.makeText(getApplicationContext(), "Utilized Inserted to DB", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Incoming Inserted to DB", Toast.LENGTH_LONG).show();
                }

                finish();
            }
        });
    }
}
