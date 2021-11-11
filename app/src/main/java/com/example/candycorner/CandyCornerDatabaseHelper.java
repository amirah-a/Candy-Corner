package com.example.candycorner;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CandyCornerDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "CandyCorner";
    private static final int DB_VERSION = 1;

    CandyCornerDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Product(" +
                   "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                   "Name  TEXT," +
                   "StockOnHand INTEGER," +
                   "StockInTransit INTEGER," +
                   "Price REAL," +
                   "ReorderQuantity INTEGER," +
                   "ReorderAmount INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
