package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TextView totalQuestions;
    TextView question;
    ImageView imgView;
    Button ans_A,ans_B,ans_C,ans_D;
    Button submitBtn;

    int score = 0;
    int totalQst = QuestionAnswer.question.length;
    public static int finalScore = 0;
    public static int finalTotalQst = 0;
    public static boolean restartQuiz = false;
    int currentQstIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //totalQuestions = findViewById(R.id.totalQuestions);
        imgView = findViewById(R.id.imageView);
        question = findViewById(R.id.question);
        ans_A = findViewById(R.id.ans_A);
        ans_B = findViewById(R.id.ans_B);
        ans_C = findViewById(R.id.ans_C);
        ans_D = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submitBtn);

        ans_A.setOnClickListener(this);
        ans_B.setOnClickListener(this);
        ans_C.setOnClickListener(this);
        ans_D.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        //totalQuestions.setText("Total questions: "+totalQst);
        LoadNewQst();

        if(restartQuiz == true){
            score = 0;
            currentQstIndex = 0;
            LoadNewQst();
        }
    }

    @Override
    public void onClick(View view) {
        ans_A.setBackgroundColor(Color.WHITE);
        ans_B.setBackgroundColor(Color.WHITE);
        ans_C.setBackgroundColor(Color.WHITE);
        ans_D.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if(clickedButton.getId() == R.id.submitBtn){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQstIndex])){
                score ++;
                selectedAnswer = "";
            }
            currentQstIndex ++;
            LoadNewQst();
        }else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.LTGRAY);
        }

    }

    void LoadNewQst(){
        if (currentQstIndex == totalQst){
            finishQuiz();
            return;
        }

        // Fetch image using glide from url
        Glide.with(getApplicationContext()).load(QuestionAnswer.img[currentQstIndex]).into(imgView);
        question.setText(QuestionAnswer.question[currentQstIndex]);
        ans_A.setText(QuestionAnswer.chaoices[currentQstIndex][0]);
        ans_B.setText(QuestionAnswer.chaoices[currentQstIndex][1]);
        ans_C.setText(QuestionAnswer.chaoices[currentQstIndex][2]);
        ans_D.setText(QuestionAnswer.chaoices[currentQstIndex][3]);
    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQst * 0.60){
            passStatus = "Passed the quiz";
        }else {
            passStatus = "Failed the quiz";
        }

        finalScore = score;
        finalTotalQst = totalQst;
        Intent intent = new Intent(getApplicationContext(), FinalActivity.class);
        startActivity(intent);
        finish();

    }
}