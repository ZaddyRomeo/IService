package com.example.romeo.iservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    EditText username,password;
    Button ticket;
    Button btntask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        username=findViewById(R.id.etUsername);
        password=findViewById(R.id.etPassword);
        ticket=findViewById(R.id.btnticket);
        btntask=findViewById(R.id.btntask);


        //
        btntask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TASK.class)); }
        });


        //

        ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),display.class));

                ticket.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((username.getText().toString().trim().equals("admin")&&(password.getText().toString().trim().equals("1234"))))
                        {

                            startActivity(new Intent(getApplicationContext(),display.class));
                        }
                        else if(username.getText().equals("")&& password.getText().equals(""))
                        {
                            Toast.makeText(getApplicationContext(),"please enter missing information",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"please enter correct information",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });}}