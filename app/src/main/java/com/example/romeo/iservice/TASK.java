package com.example.romeo.iservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TASK extends AppCompatActivity {
    EditText Technician;
    EditText Fault;
    EditText Status;
    EditText Address;
    Button btnLog,btnDB;

    Technicians technicians = new Technicians();
    Technicians technicians2 = new Technicians();
    dbhandler2 handler;

    //Technicians technician2=new Technician();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        handler=new dbhandler2(getApplicationContext());
        technicians2 = handler.display();
        Toast.makeText(getApplicationContext(),technicians2.toString(),Toast.LENGTH_SHORT).show();

        Technician = findViewById(R.id.etTechnician);
        Fault = findViewById(R.id.etFault);
        Status = findViewById(R.id.etStatus);
        Address = findViewById(R.id.etAddress);
        btnLog = findViewById(R.id.btnLog);
        btnDB = findViewById(R.id.btnDB);

        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), display2.class)); }
        });


        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInfo();
            }
        });



    }
    public void addInfo()

    {
        technicians.setTechnician(Technician.getText().toString().trim());
        technicians.setFault(Fault.getText().toString().trim());
        technicians.setAddress(Address.getText().toString().trim());
        technicians.setStatus(Status.getText().toString().trim());
        handler.getData(technicians);
        Toast.makeText(getApplicationContext(),technicians.toString(),Toast.LENGTH_SHORT).show();
    }

}
