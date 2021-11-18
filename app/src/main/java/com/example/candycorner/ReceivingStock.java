package com.example.candycorner;

import android.annotation.SuppressLint;
import android.content.Context;
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
                    TextView handVal = (TextView) findViewById(R.id.handValue);
                    TextView transVal = (TextView) findViewById(R.id.transitvalue);
                    TextView priceVal = (TextView) findViewById(R.id.pricevalue);
                    TextView quanVal = (TextView) findViewById(R.id.quantityvalue);
                    TextView amtVal = (TextView) findViewById(R.id.amtvalue);

                    handVal.setText("-");
                    transVal.setText("-");
                    priceVal.setText("-");
                    quanVal.setText("-");
                    amtVal.setText("-");
                }

                if (position == 1) {
                    itemQuery(adapterView.getContext(), "MilkyWay");
                }

                if (position == 2){
                    itemQuery(adapterView.getContext(), "Gummy Bears");
                }

                if (position == 3){
                    itemQuery(adapterView.getContext(), "Kit Kat");
                }

                if (position == 4){
                    itemQuery(adapterView.getContext(), "Jolly Ranchers");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }

    public void itemQuery(Context context, String item){
        try{
            SQLiteOpenHelper candyCornerDatabaseHelper = new CandyCornerDatabaseHelper(context);
            db = candyCornerDatabaseHelper.getWritableDatabase();
            cursor = db.query("Product",
                    new String[] {"Name", "StockOnHand", "StockInTransit", "Price", "ReorderQuantity", "ReorderAmount"},
                    "Name = ?",
                    new String[] {item},
                    null, null, null);

            TextView handVal = (TextView) findViewById(R.id.handValue);
            TextView transVal = (TextView) findViewById(R.id.transitvalue);
            TextView priceVal = (TextView) findViewById(R.id.pricevalue);
            TextView quanVal = (TextView) findViewById(R.id.quantityvalue);
            TextView amtVal = (TextView) findViewById(R.id.amtvalue);

            if (cursor != null && cursor.moveToFirst()){
                handVal.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("StockOnHand"))));
                transVal.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("StockInTransit"))));
                priceVal.setText("$" + String.valueOf(cursor.getDouble(cursor.getColumnIndex("Price"))));
                quanVal.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("ReorderQuantity"))));
                amtVal.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex("ReorderAmount"))));
            }
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }    }
}

