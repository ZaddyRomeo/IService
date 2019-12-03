package com.example.romeo.iservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class display2 extends AppCompatActivity {
    ListView lv;
    List<String> list = new ArrayList<>();
    ListAdapter adapter;
    dbhandler2 handler = new dbhandler2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);
        lv = findViewById(R.id.listviewData);
        list = handler.techniciansData();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        {
        }
    }
}
