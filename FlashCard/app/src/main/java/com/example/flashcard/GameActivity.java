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
    //region Functions
    protected int getRandomPicture(List<Integer> imageList, ImageView gameImageView){
        Random randImage = new Random();
        int randIndex = randImage.nextInt(imageList.size());
        int gameImageId = imageList.get(randIndex);
        gameImageView.setImageResource(gameImageId);
        imageList.remove(randIndex);

        return gameImageId;
    }

    protected String setGoodAnswer(int gameImageId){
        String goodAnswer;
        switch(gameImageId){
            case R.drawable.csgo_logo:
                goodAnswer = "Counter-Strike: Global Offensive";
                break;
            case R.drawable.ark_logo:
                goodAnswer = "Ark";
                break;
            case R.drawable.league_of_legends_logo:
                goodAnswer = "League of Legends";
                break;
            case R.drawable.overwatch_logo:
                goodAnswer = "Overwatch";
                break;
            case R.drawable.payday_logo:
                goodAnswer = "Payday";
                break;
            case R.drawable.final_fantasy_logo:
                goodAnswer = "Final Fantasy";
                break;
            case R.drawable.naruto_logo:
                goodAnswer = "Naruto";
                break;
            case R.drawable.r_six_logo:
                goodAnswer = "Rainbow Six Siege";
                break;
            case R.drawable.rocket_league_logo:
                goodAnswer = "Rocket League";
                break;
            case R.drawable.zelda_logo:
                goodAnswer = "Zelda";
                break;
            default:
                goodAnswer = "None";
        }
        return goodAnswer;
    }

    protected void addMultipleChoices(int radioButtonsCount, List<String> answerList, List<String> choiceList, List<String> tempList, String goodAnswer){
        for(int i = 0; i < radioButtonsCount-1; i++){
            Random rand = new Random();
            int n = rand.nextInt(answerList.size());

            // Either if the random value equals to the correct answer or to the last element in the choices list, we remove it from the answers list in order to avoid duplications.
            // Removed elements are added to a temporary list to add them back in the answers list later.
            if (answerList.get(n).equals(choiceList.get(i)) || answerList.get(n).equals(goodAnswer)){
                tempList.add(answerList.get(n));
                answerList.remove(n);
                n = rand.nextInt(answerList.size());
                choiceList.add(answerList.get(n));
            }
            else{
                choiceList.add(answerList.get(n));
                tempList.add(answerList.get(n));
                answerList.remove(n);
            }
        }
    }

    protected void setRandomRadioButtonsText(int radioButtonsCount, List<String> choiceList, RadioGroup answersRadioGroup){
        for(int i = 0; i < radioButtonsCount; i++){
            // Get a random integer within the range 0 to list.size - 1.
            Random rand = new Random();
            int n = rand.nextInt(choiceList.size());

            // Get the ID of the current iterated RadioButton.
            int radioButtonId = answersRadioGroup.getChildAt(i).getId();
            RadioButton myRadioButton = findViewById(radioButtonId);

            // Randomly picks an item from the list and set it as text to the current iterated RadioButton.
            // Then removes this item from the list to avoid to set it twice as answer.
            myRadioButton.setText(choiceList.get(n));
            choiceList.remove(n);
        }
    }
    //endregion

    //region Global lists and variables
    List<Integer> imageList = new ArrayList<>();
    List<String> answerList = new ArrayList<>();
    List<String> choiceList = new ArrayList<>();
    List<String> tempList = new ArrayList<>();
    List<CardClass> cards = CardClass.createCardGameList();

    String goodAnswer;
    int gameImageId;
    int currentQuestion = 1;
    int correctAnswer = 0;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //region Supplying items to lists
        for (CardClass card : cards){
            imageList.add(card.getImageId());
        }
        for (CardClass card : cards){
            answerList.add(card.getAnswer());
        }
        //endregion

        //region Setting up variables
        final RadioGroup answersRadioGroup = findViewById(R.id.answersRadioGroup);
        final TextView validateAnswerTextView = findViewById(R.id.validateAnswerTextView);
        final Button validateButton = findViewById(R.id.validateButton);
        final ImageView gameImageView = findViewById(R.id.gameImageView);
        final int radioButtonsCount = answersRadioGroup.getChildCount(); // getChildCount get the number of RadioButtons within the RadioGroup.
        final int maxQuestion = answerList.size();
        //endregion

        //region New Game
        // Set title of the current activity with the current question number and the amount of remaining questions.
        setTitle("GameCard - " + currentQuestion + " / " + maxQuestion);

        // Select a random picture to load when launching a new game then remove it from the list.
        gameImageId = getRandomPicture(imageList, gameImageView);

        // Set the correct answer according to the random selected picture and add it to the choice list.
        goodAnswer = setGoodAnswer(gameImageId);
        choiceList.add(goodAnswer);

        // Choices list contains at least the good answer. Reducing the RadioButtons count by 1 allows to add more different choices according to the amount of existing RadioButtons.
        // The function does not add the same answer twice!
        addMultipleChoices(radioButtonsCount, answerList, choiceList, tempList, goodAnswer);

        // Set RadioButtons text.
        setRandomRadioButtonsText(radioButtonsCount, choiceList, answersRadioGroup);

        // Elements that have been removed from the answers list are put back in it then clear the whole temporary list.
        answerList.addAll(tempList);
        tempList.clear();
        //endregion

        //region Submit answer
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateButton.getText().equals("Valider la réponse")){
                    // Get the ID of the current checked RadioButton.
                    int selectedId = answersRadioGroup.getCheckedRadioButtonId();

                    // If at least one RadioButton is checked.
                    if(selectedId != -1){
                        RadioButton selectedRadioButton = findViewById(selectedId);

                        if (selectedRadioButton.getText().equals(goodAnswer)) {
                            validateAnswerTextView.setText("Bonne réponse !");
                            validateAnswerTextView.setTextColor(Color.GREEN);
                            correctAnswer++;
                        }
                        else{
                            validateAnswerTextView.setText("Mauvaise réponse...\nLa bonne réponse était : " + goodAnswer);
                            validateAnswerTextView.setTextColor(Color.RED);
                        }

                        // Switch the button name as "Next question" or "Show results".
                        if (imageList.size() > 0){
                            validateButton.setText("Question suivante");
                        }
                        else{
                            validateButton.setText("Voir les résultats");
                        }

                        // Disable RadioButtons once the answer has been submit.
                        for(int i = 0; i < radioButtonsCount; i++){
                            answersRadioGroup.getChildAt(i).setEnabled(false);
                        }
                    }
                    else{
                        // If none of the RadioButtons is checked.
                        validateAnswerTextView.setText("Veuillez sélectionner une réponse !");
                        validateAnswerTextView.setTextColor(Color.RED);
                    }
                }
                // When the button has been switched to "Next question".
                else if (validateButton.getText().equals("Question suivante")) {
                    currentQuestion++;
                    setTitle("GameCard - " + currentQuestion + " / " + maxQuestion);

                    // Reset AnswerTextView and validateButton texts.
                    validateAnswerTextView.setText("");
                    validateButton.setText("Valider la réponse");

                    // Clear and enable RadioButtons once the "Next question" button has been pressed.
                    answersRadioGroup.clearCheck();
                    for(int i = 0; i < radioButtonsCount; i++){
                        answersRadioGroup.getChildAt(i).setEnabled(true);
                    }

                    //region Next card
                    gameImageId = getRandomPicture(imageList, gameImageView);
                    goodAnswer = setGoodAnswer(gameImageId);
                    choiceList.add(goodAnswer);
                    addMultipleChoices(radioButtonsCount, answerList, choiceList, tempList, goodAnswer);
                    setRandomRadioButtonsText(radioButtonsCount, choiceList, answersRadioGroup);
                    answerList.addAll(tempList);
                    tempList.clear();
                    //endregion
                }
                else if (validateButton.getText().equals("Voir les résultats")) {
                    Intent intent = new Intent(GameActivity.this, ResultsActivity.class);
                    intent.putExtra("correctAnswer", correctAnswer);
                    intent.putExtra("maxQuestion", maxQuestion);
                    startActivity(intent);
                }
            }
        });
        //endregion

        //region Show full-sized picture
        gameImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to another activity showing the full-sized image of the current picture.
                Intent intent = new Intent(GameActivity.this, BigSizeImageActivity.class);
                intent.putExtra("drawable", gameImageId);
                startActivity(intent);
            }
        });
        //endregion
    }
}