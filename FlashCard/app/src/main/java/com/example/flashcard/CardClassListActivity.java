package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CardClassListActivity extends AppCompatActivity {

    private List<CardClass> cards;
    private CardClassAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_class_list);

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.csgo_logo);
        imageList.add(R.drawable.ark_logo);
        imageList.add(R.drawable.league_of_legends_logo);
        imageList.add(R.drawable.overwatch_logo);
        imageList.add(R.drawable.payday_logo);
        imageList.add(R.drawable.final_fantasy_logo);
        imageList.add(R.drawable.naruto_logo);
        imageList.add(R.drawable.r_six_logo);
        imageList.add(R.drawable.rocket_league_logo);
        imageList.add(R.drawable.zelda_logo);

        List<String> answerList = new ArrayList<>();
        answerList.add("Counter-Strike: Global Offensive");
        answerList.add("Ark");
        answerList.add("League of Legends");
        answerList.add("Overwatch");
        answerList.add("Payday");
        answerList.add("Final Fantasy");
        answerList.add("Naruto");
        answerList.add("Rainbow Six Siege");
        answerList.add("Rocket League");
        answerList.add("Zelda");

        cards = new ArrayList<>();

        for (int i = 0; i < imageList.size(); i++){
            cards.add(new CardClass(imageList.get(i), answerList.get(i)));
        }

        adapter = new CardClassAdapter(cards);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}