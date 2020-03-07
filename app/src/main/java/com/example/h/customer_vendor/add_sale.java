package com.example.h.customer_vendor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class add_sale extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    // DatabaseReference myRef = db.getReference();
    // DatabaseReference customerRef=myRef.child("customers");

    EditText mobile2, name2, lending2,sale2 ,paid2, due2;
    Button btnsub2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sale);

        mobile2=(EditText)findViewById(R.id.mobile2);
        name2=(EditText)findViewById(R.id.name2);
        lending2=(EditText)findViewById(R.id.lending2);
        paid2=(EditText)findViewById(R.id.paid2);
        sale2=(EditText)findViewById(R.id.sale2);
        due2=(EditText)findViewById(R.id.due2);
        btnsub2=(Button)findViewById(R.id.btnsubmit2);




        btnsub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String mobile3=mobile2.getText().toString();
                final String name3=name2.getText().toString();
                final String lending=lending2.getText().toString();
                final String paid=paid2.getText().toString();
                final String due=due2.getText().toString();
                final String sale=sale2.getText().toString();




                Map<String, String> userMap= new HashMap<String, String>();
                String check = "^[0-9]$";
                if (mobile3.length() != 10 && mobile3.matches(check) == false) {
                    Toast.makeText(add_sale.this, "Enter a valid mobile number",
                            Toast.LENGTH_LONG).show();
                } else {

                userMap.put("mobile", mobile3);
                userMap.put("name", name3);
                userMap.put("lending", lending);
                userMap.put("paid", paid);
                userMap.put("due",due);
                userMap.put("sale",sale);


                db.collection("sale")
                        .add(userMap)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("TAG", "Sale Added" + documentReference.getId());
                                startActivity(new Intent(add_sale.this,vendor_home.class));

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("TAG", "Error adding payment", e);
                            }
                        });

            }

        }});


    }

}
