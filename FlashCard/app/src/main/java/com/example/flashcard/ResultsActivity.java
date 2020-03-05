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

        Intent srcIntent = getIntent();
        int correctAnswer = srcIntent.getIntExtra("correctAnswer", 0);
        int maxQuestion = srcIntent.getIntExtra("maxQuestion", 0);
        int winRate = (correctAnswer/maxQuestion)*100;

        TextView correctAnswersResultsTextView = findViewById(R.id.correctAnswersResultsTextView);
        TextView winRateTextView = findViewById(R.id.winRateTextView);
        correctAnswersResultsTextView.setText(correctAnswer + "/" + maxQuestion);
        winRateTextView.setText(winRate + "%\nde réussite");
        winRateTextView.setGravity(Gravity.CENTER);
        // When getting at least one wrong answer, winrate stays at 0%, why?? Float/Int issue??
    }
}
