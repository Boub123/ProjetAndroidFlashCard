package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent srcIntent = getIntent();
        int correctAnswer = srcIntent.getIntExtra("correctAnswer", 0);
        int maxQuestion = srcIntent.getIntExtra("maxQuestion", 0);
        int winRate = (100*correctAnswer)/maxQuestion;

        TextView correctAnswersResultsTextView = findViewById(R.id.correctAnswersResultsTextView);
        TextView winRateTextView = findViewById(R.id.winRateTextView);
        String correctAnswerCount = correctAnswer + " / " + maxQuestion;
        String winRateAnswers = winRate + "%\nde réussite";

        correctAnswersResultsTextView.setText(correctAnswerCount);
        winRateTextView.setText(winRateAnswers);
        winRateTextView.setGravity(Gravity.CENTER);

        findViewById(R.id.homeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.newGameButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultsActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
    }
}
