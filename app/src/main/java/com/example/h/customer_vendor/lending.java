package com.example.h.customer_vendor;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class lending extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lending);








       /* private void ReadSingleContact() {

            DocumentReference user = db.collection("PhoneBook").document("Contacts");

            user.get().addOnCompleteListener(new OnCompleteListener < DocumentSnapshot > () {

                @Override

                public void onComplete(@NonNull Task < DocumentSnapshot > task) {

                    if (task.isSuccessful()) {

                        DocumentSnapshot doc = task.getResult();

                        StringBuilder fields = new StringBuilder("");

                        fields.append("Name: ").append(doc.get("Name"));

                        fields.append("\nEmail: ").append(doc.get("Email"));

                        fields.append("\nPhone: ").append(doc.get("Phone"));

                        textDisplay.setText(fields.toString());

                    }

                }

            })

                    .addOnFailureListener(new OnFailureListener() {

                        @Override

                        public void onFailure(@NonNull Exception e) {

                        }

                    });





*/
        Toast.makeText(lending.this, "Unable to fetch records.",
                Toast.LENGTH_SHORT).show();

    }
}
