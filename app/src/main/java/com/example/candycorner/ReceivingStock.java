package com.example.candycorner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReceivingStock extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving_stock);

        Intent intent = getIntent();


        Spinner spinner = (Spinner) findViewById(R.id.candySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.candies, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0) {
                    Toast.makeText(adapterView.getContext(), "Nothing has been selected...", Toast.LENGTH_SHORT).show();

                }
                if (position == 1) {
                    try{
                        SQLiteOpenHelper candyCornerDatabaseHelper = new CandyCornerDatabaseHelper(adapter.getContext());
                        db = candyCornerDatabaseHelper.getWritableDatabase();

                        cursor = db.query("Product",
                                new String[]{"Name", "StockOnHand"},
                                "Name = ?", new String[]{"Milky Way"},null, null, null);

                        TextView tv = (TextView) findViewById(R.id.handValue);
                        int n = cursor.getCount();

                        if (cursor != null && cursor.moveToFirst()){
                            tv.setText(String.valueOf(cursor.getColumnIndex("Name")));
                        }
                        else
                            tv.setText("Empty");
                    }
                    finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                    }
                    //Toast.makeText(adapterView.getContext(),n, Toast.LENGTH_SHORT).show();

//                    db.close();
//                    cursor.close();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }
}

