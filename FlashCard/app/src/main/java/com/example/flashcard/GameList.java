package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameList extends AppCompatActivity {
   private List<FlashCard> cards;
    private GameListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        cards = new ArrayList<>();
        /*for(int i = 0; i < 15; i++)
        {
            cards.add(new FlashCard(R.drawable.final_fantasy_logo, "reponses", new ArrayList<String>()));
        }*/
        boolean add = cards.add(new FlashCard(R.drawable.final_fantasy_logo, "Final fantasy", Collections.singletonList("final_fantasy_logo")));
         cards.add(new FlashCard(R.drawable.csgo_logo, "Final fantasy", Collections.singletonList("csgo_logo")));
         cards.add(new FlashCard(R.drawable.naruto_logo, "Final fantasy", Collections.singletonList("naruto_logo")));
         cards.add(new FlashCard(R.drawable.payday_logo, "Final fantasy", Collections.singletonList("payday_logo")));
         cards.add(new FlashCard(R.drawable.overwatch_logo, "Final fantasy", Collections.singletonList("overwatch_logo")));
         cards.add(new FlashCard(R.drawable.r_six_logo, "Final fantasy", Collections.singletonList("r_six_logo")));
        cards.add(new FlashCard(R.drawable.rocket_league_logo, "Final fantasy", Collections.singletonList("rocket_league_logo")));
        cards.add(new FlashCard(R.drawable.zelda_logo, "Final fantasy", Collections.singletonList("zelda_logo")));
        cards.add(new FlashCard(R.drawable.league_of_legends_logo, "Final fantasy", Collections.singletonList("league_of_legends_logo")));
        /*cards.add(new FlashCard(R.drawable.csgo_logo, "", new ArrayList<String>()));
        cards.add(new FlashCard(R.drawable.naruto_logo, "", new ArrayList<String>()));
        cards.add(new FlashCard(R.drawable.payday_logo, "", new ArrayList<String>()));
        cards.add(new FlashCard(R.drawable.overwatch_logo, "", new ArrayList<String>()));
        cards.add(new FlashCard(R.drawable.r_six_logo, "", new ArrayList<String>()));
        cards.add(new FlashCard(R.drawable.rocket_league_logo, "", new ArrayList<String>()));
        cards.add(new FlashCard(R.drawable.zelda_logo, "", new ArrayList<String>()));
        cards.add(new FlashCard(R.drawable.league_of_legends_logo, "", new ArrayList<String>()));
        cards.add(new FlashCard(R.drawable.guess_game_logo, "", new ArrayList<String>()));
        cards.add(new FlashCard(R.drawable.ark_logo, "", new ArrayList<String>()));*/


        adapter = new GameListAdapter(cards);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
