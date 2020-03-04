package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //region Setting up variables
        final RadioGroup answersRadioGroup = findViewById(R.id.answersRadioGroup);
        final TextView validateAnswerTextView = findViewById(R.id.validateAnswerTextView);
        final Button validateButton = findViewById(R.id.validateButton);
        final ImageView gameImageView = findViewById(R.id.gameImageView);
        final int gameImageId = R.drawable.csgo_logo;
        final String goodAnswer = "CS:GO";
        //endregion

        List<String> list;
        list = new ArrayList<>();
        list.add("CS:GO");
        list.add("Overwatch");
        list.add("Crysis");

        gameImageView.setImageResource(gameImageId);

        // getChildCount get the number of RadioButtons within the RadioGroup.
        int radioButtonsCount = answersRadioGroup.getChildCount();

        for(int i = 0; i < radioButtonsCount; i++){
            // Get a random integer within the range 0 to list.size - 1.
            Random rand = new Random();
            int n = rand.nextInt(list.size());

            // Get the ID of the current iterated RadioButton.
            int radioButtonId = answersRadioGroup.getChildAt(i).getId();
            RadioButton myRadioButton = findViewById(radioButtonId);

            // Randomly picks an item from the list and set it as text to the current iterated RadioButton.
            // Then removes this item from the list to avoid to set it twice as text.
            myRadioButton.setText(list.get(n));
            list.remove(n);
        }
        /*Log.i("childCount", String.valueOf(answersRadioGroup.getChildCount()));
        Log.i("getChild", String.valueOf(answersRadioGroup.getChildAt(0).getId()));*/

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = answersRadioGroup.getCheckedRadioButtonId();

                if(selectedId != -1){
                    RadioButton selectedRadioButton = findViewById(selectedId);

                    if (selectedRadioButton.getText().equals(goodAnswer)) {
                        validateAnswerTextView.setText("Bonne réponse !");
                        validateAnswerTextView.setTextColor(Color.GREEN);
                    }
                    else{
                        validateAnswerTextView.setText("Mauvaise réponse...\nLa bonne réponse était : " + goodAnswer);
                        validateAnswerTextView.setTextColor(Color.RED);
                    }
                }
                else{
                    validateAnswerTextView.setText("Veuillez sélectionner une réponse !");
                    validateAnswerTextView.setTextColor(Color.RED);
                }
            }
        });

        gameImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to another activity showing the full-sized image.
                Intent intent = new Intent(GameActivity.this, BigSizeImageActivity.class);
                intent.putExtra("drawable", gameImageId);
                startActivity(intent);
            }
        });
    }
}
