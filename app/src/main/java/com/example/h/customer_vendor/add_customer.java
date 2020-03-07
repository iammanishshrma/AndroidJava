package com.example.h.customer_vendor;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class add_customer extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText mobile, name, limit, password;
    Button button9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);


        mobile=(EditText)findViewById(R.id.mobileno);
        name=(EditText)findViewById(R.id.cname);
        limit=(EditText)findViewById(R.id.limit);
        password=(EditText)findViewById(R.id.password);
        button9=(Button)findViewById(R.id.button9);




        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               final String mobileno=mobile.getText().toString();
               final String cname=name.getText().toString();
               final String climit=limit.getText().toString();
               final String cpassword=password.getText().toString();
                Map<String, String> userMap = new HashMap<String, String>();
               String check="^[0-9]$";
               if(mobileno.length()!=10 && mobileno.matches(check)==false)
               {
                   Toast.makeText(add_customer.this, "Enter a valid mobile number",
                           Toast.LENGTH_LONG).show();
               } else {
                   userMap.put("mobileno", mobileno);
                   userMap.put("name", cname);
                   userMap.put("limit", climit);
                   userMap.put("password", cpassword);


                   db.collection("customers")
                           .add(userMap)
                           .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                               @Override
                               public void onSuccess(DocumentReference documentReference) {
                                   Log.d("TAG", "Customer Added" + documentReference.getId());
                                   Toast.makeText(add_customer.this, "Customer Added Successfully",
                                           Toast.LENGTH_LONG).show();
                                   mobile.setText("");
                                   name.setText("");
                                   //email.setText("");
                                   password.setText("");
                                   limit.setText("");
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Log.w("TAG", "Error adding Customer", e);
                                   Toast.makeText(add_customer.this, "Failed",
                                           Toast.LENGTH_LONG).show();
                               }
                           });

            }}
        });


    }

}
