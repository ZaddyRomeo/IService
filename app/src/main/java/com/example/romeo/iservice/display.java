package com.example.romeo.iservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class display extends AppCompatActivity {
    ListView lv;
    List<String> list = new ArrayList<>();
    ListAdapter adapter;
    dbhandler handler = new dbhandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        lv = findViewById(R.id.listviewData);
        list = handler.clientsData();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        {
        }
    }
}