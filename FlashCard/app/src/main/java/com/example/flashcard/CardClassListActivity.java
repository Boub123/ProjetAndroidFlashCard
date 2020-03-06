package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CardClassListActivity extends AppCompatActivity {

    private List<CardClass> cards = new ArrayList<>();
    private CardClassAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_class_list);
        setTitle("Questions");

        // Supplying game images and titles to cards list.
        cards = CardClass.createCardGameList();
        //Log.i("LOG_CAT", cards.get(0).getImageId() + " " + cards.get(0).getAnswer());

        adapter = new CardClassAdapter(cards);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

// TODO
// Create new interface allowing user to add pictures and set the video game title.
// TODO