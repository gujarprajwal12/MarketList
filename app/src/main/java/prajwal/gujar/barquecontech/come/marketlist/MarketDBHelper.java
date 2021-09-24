package prajwal.gujar.barquecontech.come.marketlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import prajwal.gujar.barquecontech.come.marketlist.MarketContract.MarketEntry;

public class MarketDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "marketlist.db";
    public static final int DATABASE_VERSION = 1;

    public MarketDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MARKETLIST_TABLE = "CREATE TABLE " +
                MarketEntry.TABLE_NAME + " (" +
                MarketEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MarketEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                MarketEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                MarketEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        db.execSQL(SQL_CREATE_MARKETLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MarketEntry.TABLE_NAME);
        onCreate(db);
    }
}