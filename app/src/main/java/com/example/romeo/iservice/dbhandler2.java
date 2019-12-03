package com.example.romeo.iservice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class dbhandler2 extends SQLiteOpenHelper {
    //database version
    private static final int DATABASE_VERSION=1;

    //database name
    private static final String DATABASE_NAME="ZTechnicians.db";//

    //table names
    private static final String
            TABLE_TECH="TECH";//name of the table you want to create

    String TECHQuery="CREATE TABLE IF NOT EXISTS TECH(id INTEGER PRIMARY KEY AUTOINCREMENT,technician VARCHAR(255),fault VARCHAR(255),status VARCHAR(255),address VARCHAR(255))";
    public dbhandler2(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TECH);
        onCreate(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TECHQuery);

    }
    public void getData(Technicians technicians)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("technician",technicians. getTechnician());
        values.put("fault",technicians. getFault());
        values.put("status",technicians. getStatus());
        values.put("address",technicians. getAddress());
        db.insert("TECH",null,values);

    }
    public Technicians display() {
        SQLiteDatabase db = getWritableDatabase();
        String infoquery = "select* from TECH";
        Cursor cursor = db.rawQuery(infoquery,null);
        Technicians technicians=new Technicians();
        while(cursor.moveToNext()) {
            technicians.setFault(cursor.getString(cursor.getColumnIndex("fault")));
            technicians.setTechnician(cursor.getString(cursor.getColumnIndex("technician")));
            technicians.setStatus(cursor.getString(cursor.getColumnIndex("status")));
            technicians.setAddress(cursor.getString(cursor.getColumnIndex("address")));




        }
        return technicians;

    }


    public List<String> techniciansData()
    {
        ArrayList<String> lst=new ArrayList();
        SQLiteDatabase db = getWritableDatabase();
        String infoquery = "select* from TECH";
        Cursor cursor = db.rawQuery(infoquery, null);
        while(cursor.moveToNext()) {
            Technicians technicians=new Technicians();
            technicians.setFault(cursor.getString(cursor.getColumnIndex("fault")));
            technicians.setStatus(cursor.getString(cursor.getColumnIndex("status")));
            technicians.setTechnician(cursor.getString(cursor.getColumnIndex("technician")));
            technicians.setAddress(cursor.getString(cursor.getColumnIndex("address")));


            lst.add(technicians.toString());

        }
        return lst;
    }






}
