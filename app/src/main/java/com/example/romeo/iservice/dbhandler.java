package com.example.romeo.iservice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class dbhandler extends SQLiteOpenHelper {
    //database version
    private static final int DATABASE_VERSION=1;

    //database name
    private static final String DATABASE_NAME="ZClients.db";//

    //table names
    private static final String
            TABLE_TICKETS="ticket";//name of the table you want to create

    String ticketQuery="CREATE TABLE IF NOT EXISTS ticket(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(255),service_number VARCHAR(255),message VARCHAR(255),contactno VARCHAR(255))";
    public dbhandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TICKETS);
        onCreate(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ticketQuery);

    }
    public void getData(Clients clients)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values = new
                ContentValues();
        values.put("name",clients. getName());
        values.put("service_number",clients. getService_number());
        values.put("message",clients. getMessage());
        values.put("contactno",clients. getContactno());
        db.insert("ticket",null,values);

    }
    public Clients display() {
        SQLiteDatabase db = getWritableDatabase();
        String infoquery = "select* from ticket";
        Cursor cursor = db.rawQuery(infoquery, null);
        Clients clients=new Clients();
        while(cursor.moveToNext()) {
            clients.setService_number(cursor.getString(cursor.getColumnIndex("service_number")));
            clients.setName(cursor.getString(cursor.getColumnIndex("name")));
            clients.setMessage(cursor.getString(cursor.getColumnIndex("message")));
            clients.setContactno(cursor.getString(cursor.getColumnIndex("contactno")));




        }
        return clients;

    }


    public List<String> clientsData()
    {
        ArrayList<String> lst=new ArrayList();
        SQLiteDatabase db = getWritableDatabase();
        String infoquery = "select* from ticket";
        Cursor cursor = db.rawQuery(infoquery, null);
        while(cursor.moveToNext()) {
            Clients clients=new Clients();
            clients.setService_number(cursor.getString(cursor.getColumnIndex("service_number")));
            clients.setName(cursor.getString(cursor.getColumnIndex("name")));
            clients.setMessage(cursor.getString(cursor.getColumnIndex("message")));
            clients.setContactno(cursor.getString(cursor.getColumnIndex("contactno")));


            lst.add(clients.toString());

        }
        return lst;
    }





}

