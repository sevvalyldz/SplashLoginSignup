package com.example.my_bm_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Splash1 extends AppCompatActivity {

    Button bttnLogınEt,bttnSıgnUpEt;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);
        bttnLogınEt=findViewById(R.id.bttnLogınEt);
        bttnSıgnUpEt=findViewById(R.id. bttnSıgnUpEt);
        auth = FirebaseAuth.getInstance();


        bttnLogınEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));


            }
        });
        bttnSıgnUpEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));


            }
        });


    }
}