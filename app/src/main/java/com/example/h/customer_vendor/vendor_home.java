package com.example.h.customer_vendor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vendor_home extends AppCompatActivity {
    private Button buttonl;
    private Button buttonac;
    private Button buttonap;
    private Button buttonas;
    private Button buttonma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_home);

        buttonl=(Button)findViewById(R.id.button3);
        buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlending();
            }
        });

        buttonac=(Button)findViewById(R.id.button5);
        buttonac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openadd_customer();
            }
        });
        buttonas=(Button)findViewById(R.id.button6);
        buttonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openadd_sale();
            }
        });

        buttonap=(Button)findViewById(R.id.button7);
        buttonap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openadd_payment();
            }
        });

        buttonma=(Button)findViewById(R.id.button8);
        buttonma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });


    }
        public void openlending(){
            Intent intentl= new Intent(this,lending.class);
            startActivity(intentl);
        }
    public void openadd_customer(){
        Intent intentac= new Intent(this,add_customer.class);
        startActivity(intentac);
    }
    public void openadd_payment(){
        Intent intentap= new Intent(this,add_payment.class);
        startActivity(intentap);
    }
    public void openadd_sale(){
        Intent intentas= new Intent(this,add_sale.class);
        startActivity(intentas);
    }
    public void openMainActivity(){
        Intent intentma= new Intent(this,MainActivity.class);
        startActivity(intentma);
    }

}
