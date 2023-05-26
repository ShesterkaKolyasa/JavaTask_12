package com.mirea.kt.android2023.homework2_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class StorageActivity extends AppCompatActivity {

    private ArrayList<Storage> storages;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        RecyclerView rcView = findViewById(R.id.recyclerView);
        this.dbManager = new DBManager(new MySQLHelper(this, "my_database.db", null, 1));
        storages = dbManager.loadAllStoragesFromDatabase();
        Log.i("Магазины из активити", String.valueOf(storages));
        if(!storages.isEmpty()){
            Toast.makeText(this, "успешная загрузка", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
        }
        StorageAdapter adapter = new StorageAdapter(storages);
        rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcView.setAdapter(adapter);

    }
}