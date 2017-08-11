package com.demo.lizejun.updatedatabase;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";

    private static final String DB_NAME = "table.db";
    private static final int DB_VERSION = 3;

    private static final String CREATE_FIRST_TABLE = "create table if not exists first_table ("
            + "id integer primary key,"
            + "column1 integer)";

    private static final String CREATE_SECOND_TABLE = "create table if not exists second_table ("
            + "id integer primary key,"
            + "column1 integer, column2 integer)";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        db.execSQL(CREATE_FIRST_TABLE);
        db.execSQL(CREATE_SECOND_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "oldVersion=" + oldVersion + ",newVersion=" + newVersion);
        if (oldVersion < 2) {
            db.execSQL(CREATE_SECOND_TABLE);
        }
        if (oldVersion < 3) {
            db.execSQL("ALTER TABLE second_table ADD column2 integer");
        }
    }
}
