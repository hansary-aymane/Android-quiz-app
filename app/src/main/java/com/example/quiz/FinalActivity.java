package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FinalActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;

    TextView userName, congrats;
    TextView result1;
    Button tryAgain, signOut;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        congrats = findViewById(R.id.congrats);
        userName = findViewById(R.id.userName);
        result1 = findViewById(R.id.result1);
        tryAgain = findViewById(R.id.tryAgain);
        signOut = findViewById(R.id.signOut);

        String[] parts = user.getEmail().split("@");
        userName.setText(parts[0].toUpperCase());
        result1.setText("Your grade "+ (MainActivity.finalScore * 100 /MainActivity.finalTotalQst ) +"%");
        result1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        if (MainActivity.finalScore * 100 /MainActivity.finalTotalQst < 80){
            congrats.setText("I'm sorry, but you didn't pass.");
            result1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_report_gmailerrorred_24, 0, 0,0);
        }

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.restartQuiz = true;
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), FirstActivity.class));
                finish();
            }
        });
    }
}