package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        int goodReponse = getIntent().getIntExtra("goodReponse", 0);

        int maxQuestion = getIntent().getIntExtra("maxQuestions", 0);
        int winRate = (100*goodReponse)/maxQuestion;

        TextView textView = findViewById(R.id.textViewGoodRep);
        textView.setText(goodReponse + "");

        TextView textView1 = findViewById(R.id.winRateTextView);
        textView1.setText(winRate + "%");
    }
}