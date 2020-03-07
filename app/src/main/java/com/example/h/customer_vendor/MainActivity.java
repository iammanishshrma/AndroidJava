package com.example.h.customer_vendor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button buttonc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openvendor_login();

            }
        });

        buttonc=(Button)findViewById(R.id.button2);
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencustomer_login();
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
    }


    public void openvendor_login()
    {
        Intent intent= new Intent(this,vendor_login.class);
        startActivity(intent);
    }


    public void opencustomer_login(){
        Intent intentc=new Intent(this,customer_login.class);
        startActivity(intentc);
    }






}
