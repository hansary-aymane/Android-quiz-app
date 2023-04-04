package com.example.quiz;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class QuestionAnswer {

    //public static ArrayList<String> img_ = new ArrayList<>();
    //public static ArrayList<String> question_ = new ArrayList<>();

    /*public QuestionAnswer() {
        DatabaseReference img = FirebaseDatabase.getInstance().getReference().child("img");
        img.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                img_.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    img_.add(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        DatabaseReference question = FirebaseDatabase.getInstance().getReference().child("question");
        question.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                question_.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    question_.add(snapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }*/

    public static String img[] = {
            "https://cdn.britannica.com/36/162636-050-932C5D49/Colosseum-Rome-Italy.jpg",
            "https://cdn.mappr.co/wp-content/uploads/2022/12/romania-location-map.jpg",
            "https://img.freepik.com/premium-vector/man-think-wondering-with-question-marks-guy-confuse-illustration_619097-78.jpg",
            "https://www.sporcle.com/blog/wp-content/uploads/2018/08/1-6.jpg",
            "https://images.indianexpress.com/2023/02/Ronaldo-10.jpg",
            "https://www.worldatlas.com/r/w768/upload/f1/f2/09/untitled-design-260.jpg",
            "https://static.dw.com/image/16774046_605.jpg",
            "https://cdn.britannica.com/94/75394-050-C3F58654/World-map-Continents-Oceans-Seas.jpg"
    };

    public static String question[] = {
            "In which Italian city can you find the Colosseum ?",
            "Which country does not share a border with Romania ?",
            "How many sides has a Hexagon ?",
            "What is the longest river in the world ?",
            "Which country is the footballer Cristiano Ronaldo from ?",
            "Which famous inventor invented the telephone ?",
            "Which French king was nicknamed the “Sun King” ?",
            "What is the largest continent in size ?"
    };

    public static String chaoices [][] = {
            {"Venice", "Rome", "Naples", "Milan"},
            {"Ukraine", "Bulgaria", "Hungary", "Poland"},
            {"5", "6", "7", "8"},
            {"Amazon River", "Nile", "Yellow River", "Congo River"},
            {"Spain", "Brazil", "Uruguay", "Portugal"},
            {"Thomas Edison", "Benjamin Franklin", "Alexander Graham Bell", "Nikola Tesla"},
            {"Louis XVI", "Charlemagne", "Francis I", "Louis XIV"},
            {"Asia", "Africa", "Europe", "North America"}
    };

    public static String correctAnswers[] = {
            "Rome",
            "Poland",
            "6",
            "Nile",
            "Portugal",
            "Alexander Graham Bell",
            "Louis XIV",
            "Asia"
    };
}