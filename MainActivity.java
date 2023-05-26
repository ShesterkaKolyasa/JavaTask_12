package com.mirea.kt.android2023.homework2_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextAddress, editTextOpen, editTextClose, editTextName;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dbManager = new DBManager(new MySQLHelper(this, "my_database.db", null, 1));
        editTextAddress = findViewById(R.id.etAddress);
        editTextName = findViewById(R.id.etName);
        editTextOpen = findViewById(R.id.etOpen);
        editTextClose = findViewById(R.id.etClose);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btnNext);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btnAdd){
            if(this.dbManager != null){
                String address = editTextAddress.getText().toString();
                String name = editTextName.getText().toString();
                String open = editTextOpen.getText().toString();
                String close = editTextClose.getText().toString();
                if(!address.isEmpty() && !name.isEmpty() && !open.isEmpty() && !close.isEmpty()){
                    boolean result = dbManager.saveStorageDatabase(new Storage(address, name, open, close));
                    if(result){
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }
            }
        }else if(v.getId() == R.id.btnNext) {
            startActivity(new Intent(this, StorageActivity.class));
        }
    }
}