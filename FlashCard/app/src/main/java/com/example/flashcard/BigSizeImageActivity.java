package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class BigSizeImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_size_image);

        Intent srcIntent = getIntent();
        int n = srcIntent.getIntExtra("drawable", 0);
        ImageView bigSizeImageView = findViewById(R.id.bigSizeImageView);
        bigSizeImageView.setImageResource(n);
    }
}
