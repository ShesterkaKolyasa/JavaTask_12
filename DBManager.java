package com.mirea.kt.android2023.homework2_12;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBManager {
    private SQLiteOpenHelper sqLiteHelper;

    public DBManager(SQLiteOpenHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public boolean saveStorageDatabase(Storage storage){
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("address", storage.getAddress());
        cv.put("name", storage.getName());
        cv.put("open" , storage.getOpen());
        cv.put("close", storage.getClose());
        long rowId = db.insert("TABLE_STORAGES", null,cv);
        cv.clear();
        db.close();
        return rowId != -1;
    }

    public ArrayList<Storage> loadAllStoragesFromDatabase(){
        ArrayList<Storage> storages = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_STORAGES",
                null,null,null,
                null,null,null);
        if(dbCursor.moveToFirst()){
            do{
                String address = dbCursor.getString(dbCursor.getColumnIndexOrThrow("address"));
                String name = dbCursor.getString(dbCursor.getColumnIndexOrThrow("name"));
                String open = dbCursor.getString(dbCursor.getColumnIndexOrThrow("open"));
                String close = dbCursor.getString(dbCursor.getColumnIndexOrThrow("close"));
                storages.add(new Storage(address, name, open, close));
            } while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        Log.i("Количество магазинов: ", String.valueOf(storages.size()));
        Log.i("Магазины: ", String.valueOf(storages));
        return storages;
    }

    public void deleteTable(){
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS my_database.db");
    }
}
