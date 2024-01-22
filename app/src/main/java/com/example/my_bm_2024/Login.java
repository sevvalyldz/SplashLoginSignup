package com.example.my_bm_2024;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_bm_2024.ui.About.about;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText etEmail,etPass;
    Button bttnLogın;

    Button bttn_signup;

    FirebaseAuth auth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail=findViewById(R.id.etEmail);
        etPass=findViewById(R.id.etPass);
        bttnLogın=findViewById(R.id.bttnLogın);
        bttn_signup=findViewById(R.id.bttn_signup);
        auth = FirebaseAuth.getInstance();

        bttnLogın.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();



            }
        });
        bttn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));


            }
        });

    }
    private void login(){
        String email=etEmail.getText().toString();
        String password=etPass.getText().toString();

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this,"Login Başarılı",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),BlankFragment.class);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(Login.this,"E mail veya parola yanlış",Toast.LENGTH_SHORT).show();

                        }
                    }
                }
        );

    }
}