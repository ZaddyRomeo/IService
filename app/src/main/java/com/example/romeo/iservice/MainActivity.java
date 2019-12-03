package com.example.romeo.iservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText service_number;
    EditText Message;
    EditText Contactno;
    Button btnAdmin,btnsubmit;

    Clients clients= new Clients();
    Clients clients2= new Clients();
    dbhandler handler;

    //Clients clients2=new Clients();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler=new dbhandler(getApplicationContext());
        clients2 = handler.display();
        Toast.makeText(getApplicationContext(),clients2.toString(),Toast.LENGTH_SHORT).show();

        Name = findViewById(R.id.etName);
        service_number = findViewById(R.id.etservice);
        Message = findViewById(R.id.etMessage);
        Contactno = findViewById(R.id.etContactno);
        btnsubmit = findViewById(R.id.btnLog);
        btnAdmin= findViewById(R.id.btnAdmin);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInfo();
            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdminActivity.class)); }
        });


    }
    public String getsysDate(){
        String timesStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
        return timesStamp;

        }

        public void addInfo()
        {
            clients.setName(Name.getText().toString().trim());
            clients.setService_number(service_number.getText().toString().trim());
            clients.setMessage(Message.getText().toString().trim());
            clients.setContactno(Contactno.getText().toString().trim());
            clients.setDate(getsysDate());
            handler.getData(clients);
            Toast.makeText(getApplicationContext(),clients.toString(),Toast.LENGTH_SHORT).show();
        }
    }







