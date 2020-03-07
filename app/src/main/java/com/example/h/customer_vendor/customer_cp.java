package com.example.h.customer_vendor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customer_cp extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_cp);

        button=(Button)findViewById(R.id.button20);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencustomer_login();
            }
        });



    }
    public void opencustomer_login(){
        Intent intent=new Intent(this,customer_login.class);
        startActivity(intent);
    }

}
