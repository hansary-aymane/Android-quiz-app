package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    EditText email, passWrod;
    Button register;
    ProgressBar progressBar;
    TextView backSignin;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        passWrod = findViewById(R.id.passWrod);
        register = findViewById(R.id.register);
        progressBar = findViewById(R.id.progressBar);
        backSignin = findViewById(R.id.back_signin);

        backSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 progressBar.setVisibility(View.VISIBLE);
                 String Email, Password;
                 Email = String.valueOf(email.getText());
                 Password = String.valueOf(passWrod.getText());

                if(TextUtils.isEmpty(Email)){
                    Toast.makeText(SignUpActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                     Toast.makeText(SignUpActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                     return;
                }

                 mAuth.createUserWithEmailAndPassword(Email, Password)
                         .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 progressBar.setVisibility(View.GONE);
                                 if (task.isSuccessful()) {
                                     Toast.makeText(SignUpActivity.this, "Account created.",
                                             Toast.LENGTH_SHORT).show();
                                     Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                     startActivity(intent);
                                     finish();
                                 } else {
                                     Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                             Toast.LENGTH_SHORT).show();
                                 }
                             }
                         });
             }
         });
    }
}