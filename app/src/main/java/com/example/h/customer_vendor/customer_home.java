package com.example.h.customer_vendor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customer_home extends AppCompatActivity {
    private Button buttonvs;
    private Button buttonvp;
    private Button buttonvl;
    private Button buttoncp;
    private Button buttonma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        buttonvs=(Button)findViewById(R.id.button14);
        buttonvs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openview_sale();
            }
        });


        buttonvp=(Button)findViewById(R.id.button15);
        buttonvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openview_payment();
            }
        });

        buttonvl=(Button)findViewById(R.id.button16);
        buttonvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openview_lending();
            }
        });

        buttoncp=(Button)findViewById(R.id.button17);
        buttoncp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencustomer_cp();
            }
        });

        buttonma=(Button)findViewById(R.id.button18);
        buttonma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }

        public void openview_sale(){
            Intent intentvs= new Intent(this, view_sale.class);
            startActivity(intentvs);
        }

    public void openview_payment(){
        Intent intentvp= new Intent(this, view_payment.class);
        startActivity(intentvp);
    }

    public void openview_lending(){
        Intent intentvl= new Intent(this, view_lending.class);
        startActivity(intentvl);
    }


    public void opencustomer_cp(){
        Intent intentcp= new Intent(this, customer_cp.class);
        startActivity(intentcp);
    }

    public void openMainActivity(){
        Intent intentma= new Intent(this, MainActivity.class);
        startActivity(intentma);
    }

}
