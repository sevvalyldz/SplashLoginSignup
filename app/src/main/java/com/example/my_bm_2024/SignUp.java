package com.example.my_bm_2024;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.CollationElementIterator;

public class SignUp extends AppCompatActivity {
    EditText et_Email, et_Password,etname,etLastname;
    Button bttn_login;

    Button bttnsignup;

    FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        et_Email = findViewById(R.id.et_Email);
        etname = findViewById(R.id.etname);
        etLastname = findViewById(R.id.etLastname);
        et_Password = findViewById(R.id.et_Password);
        bttn_login = findViewById(R.id.bttn_login);
        bttnsignup = findViewById(R.id.bttnsignup);
        auth = FirebaseAuth.getInstance();

        bttn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
        bttnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etname.getText().toString();
                String Lastname=etLastname.getText().toString();
                String email = et_Email.getText().toString();
                String password = et_Password.getText().toString();
                FirebaseAuth auth=FirebaseAuth.getInstance();
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    String uid=task.getResult().getUser().getUid();
                                    Toast.makeText(SignUp.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),Login.class));

                                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                                    CollectionReference ref =db.collection("My_Proje");
                                    My_Proje user=new My_Proje(name,Lastname,email);
                                    ref.add(user);







                                }

                            }
                        });
            }
        });
    }
}