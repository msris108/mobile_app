package com.example.preparation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "employee_database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE employee (eName TEXT, ePhone TEXT, eEmail TEXT, eAddress TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS employee");
    }

    public boolean insert(String eName, String ePhone, String eEmail, String eAddress) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eName", eName);
        contentValues.put("ePhone", ePhone);
        contentValues.put("eEmail", eEmail);
        contentValues.put("eAddress", eAddress);

        long result = sqLiteDatabase.insert("employee", null, contentValues);

        return result != -1;
    }

    public boolean update(String eName, String ePhone, String eEmail, String eAddress) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eName", eName);
        contentValues.put("ePhone", ePhone);
        contentValues.put("eEmail", eEmail);
        contentValues.put("eAddress", eAddress);

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM employee WHERE eEmail =? LIMIT 1", new String[] {eEmail});
        if (cursor.getCount() > 0) {
            long result =sqLiteDatabase.update("employee",  contentValues, "eEmail=?", new String[] {eEmail});
            return result != -1;
        }
        return false;
    }

    public boolean delete(String eEmail) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM employee WHERE eEmail =?", new String[] {eEmail});
        if (cursor.getCount() > 0) {
            long result =sqLiteDatabase.delete("employee",  "eEmail=?", new String[] {eEmail});
            return result != -1;
        }
        return false;
    }

    public Cursor view() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM employee", null);
        return cursor;
    }
}
