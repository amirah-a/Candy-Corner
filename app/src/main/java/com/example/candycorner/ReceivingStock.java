package com.example.candycorner;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
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
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0) {
                    Toast.makeText(adapterView.getContext(), "Nothing has been selected...", Toast.LENGTH_SHORT).show();

                }
                if (position == 1) {
                    try{
//                        SQLiteOpenHelper candyCornerDBHelper = new CandyCornerDatabaseHelper(getApplicationContext());
//                        db = candyCornerDBHelper.getReadableDatabase();
//
////                        cursor = db.query("Product",
////                                new String[]{"StockOnHand", "StockInTransit", "Price", "ReorderQuantity", "ReorderAmount"},
////                                "Name = ?", new String[]{"MilkyWay"},null, null, null);
//
                        TextView tv = (TextView) findViewById(R.id.handValue);
                        tv.setText("MilkyWay");
//                        cursor = db.query("Product",
//                                new String[]{"StockOnHand", "StockInTransit", "Price", "ReorderQuantity", "ReorderAmount"},
//                                "Name = ?", new String[]{"MilkyWay"},null, null, null);
//
//                        while (cursor.moveToNext()) {
//                            tv.setText(String.valueOf(cursor.getInt(1)));
//                        }
//                        cursor.close();
//                        db.close();
                    }
                    catch (SQLiteException e) {
                        String s = e.getMessage();
                        Toast.makeText(adapterView.getContext(), "Database unavailable: " + s,
                                Toast.LENGTH_LONG).show();
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }
}

