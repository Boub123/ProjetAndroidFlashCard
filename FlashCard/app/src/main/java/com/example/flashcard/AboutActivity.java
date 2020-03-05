package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("À propos");

        // Get current build version.
        String versionName = BuildConfig.VERSION_NAME;

        // Show current build version (dynamically).
        TextView appVersionTextView = findViewById(R.id.appVersionTextView);
        appVersionTextView.setText(versionName);
    }
}
