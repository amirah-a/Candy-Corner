package com.example.candycorner;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CandyCornerDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "CandyCorner";
    private static final int DB_VERSION = 1;
    private static final String COL_NAME = "Name";
    private static final String COL_STOCKONHAND = "StockOnHand";
    private static final String COL_STOCKINTRANSIT = "StockInTransit";
    private static final String COL_PRICE = "Price";
    private static final String COL_REORDERQUANTITY = "ReorderQuantity";
    private static final String COL_REORDERAMOUNT = "ReorderAmount";

    CandyCornerDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Product(" +
                   "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_NAME + " TEXT," +
                    COL_STOCKONHAND +" INTEGER," +
                    COL_STOCKINTRANSIT + " INTEGER," +
                    COL_PRICE + " REAL," +
                    COL_REORDERQUANTITY + " INTEGER," +
                    COL_REORDERAMOUNT + " INTEGER);");

        insertCandy(db, "MilkyWay", 15, 8, 2.99, 5, 12);
        insertCandy(db, "Gummy Bears", 2, 10, 5.00, 8, 9);
        insertCandy(db, "Kit Kat", 7, 8, 2.65, 20, 7);
        insertCandy(db, "Jolly Ranchers", 15, 8, 2.99, 5, 12);



    }

    private static  void insertCandy(SQLiteDatabase db, String name, int hand, int transit,
                                     double price, int reorderQuan, int reorderAmt){
        ContentValues candyValues = new ContentValues();
        candyValues.put(COL_NAME, name);
        candyValues.put(COL_STOCKONHAND, hand);
        candyValues.put(COL_STOCKINTRANSIT, transit);
        candyValues.put(COL_PRICE, price);
        candyValues.put(COL_REORDERQUANTITY, reorderQuan);
        candyValues.put(COL_REORDERAMOUNT, reorderAmt);
        db.insert(DB_NAME, null, candyValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
