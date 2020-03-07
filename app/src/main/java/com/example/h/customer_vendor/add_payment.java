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

public class add_payment extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    // DatabaseReference myRef = db.getReference();
    // DatabaseReference customerRef=myRef.child("customers");

    EditText mobile1, name1, lending1, paid1, due1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);

        mobile1=(EditText)findViewById(R.id.mobile);
        name1=(EditText)findViewById(R.id.name);
        lending1=(EditText)findViewById(R.id.lending);
        paid1=(EditText)findViewById(R.id.paid);
        due1=(EditText)findViewById(R.id.due);
        button1=(Button)findViewById(R.id.btnsubmit);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String mobile2 = mobile1.getText().toString();
                final String name2 = name1.getText().toString();
                final String lending = lending1.getText().toString();
                final String paid = paid1.getText().toString();
                final String due = due1.getText().toString();


                Map<String, String> userMap = new HashMap<String, String>();
                String check = "^[0-9]$";
                if (mobile2.length() != 10 && mobile2.matches(check) == false) {
                    Toast.makeText(add_payment.this, "Enter a valid mobile number",
                            Toast.LENGTH_LONG).show();
                } else {
                    userMap.put("mobile", mobile2);
                    userMap.put("name", name2);
                    userMap.put("lending", lending);
                    userMap.put("paid", paid);
                    userMap.put("due", due);


                    db.collection("payment")
                            .add(userMap)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d("TAG", "Payment Added" + documentReference.getId());
                                    startActivity(new Intent(add_payment.this, vendor_home.class));

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
