package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "SampleData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE SampleTable (uname TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SampleTable");
    }

    public boolean insert(String uname, String password) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("uname", uname);
        contentValues.put("password", password);

        long result = sqLiteDatabase.insert("SampleTable", null, contentValues);

        return result != -1;
    }

    public boolean update(String uname, String password) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("uname", uname);
        contentValues.put("password", password);

        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SampleData WHERE uname = ?", new String[] {uname});

        if (cursor.getCount() > 0) {
            long result = sqLiteDatabase.update("SampleTable", contentValues, "uname=?", new String[] {uname});
            return result != -1;
        }
        else return false;
    }

    public boolean delete(String uname) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SampleTable WHERE uname = ?", new String[] {uname});
        if (cursor.getCount() > 0) {
            long result = sqLiteDatabase.delete("SampleTable", "uname=?", new String[] {uname});
            return result != -1;
        }
        else return false;
    }

    public Cursor ViewAll() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SampleTable", null);
        return cursor;
    }

    public Cursor ViewOne(String uname) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SampleTable WHERE uname = ?", new String[] {uname});
        return cursor;
    }
}
