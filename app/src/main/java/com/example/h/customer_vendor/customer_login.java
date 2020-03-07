package com.example.h.customer_vendor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class customer_login extends AppCompatActivity {
    private Button buttonl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);


        buttonl=(Button)findViewById(R.id.button12);

        buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                opencustomer_home();
            }
        });

    }

    public void opencustomer_home(){
        Intent intent=new Intent(this,customer_home.class);
        startActivity(intent);
    }
}
