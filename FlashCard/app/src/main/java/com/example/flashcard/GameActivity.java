package com.example.flashcard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private static final int REQUEST_A = 1;
    public static final String EXTRA_LISTFLASHCARD = "listFlashCard";
    public static final String EXTRA_FLASHCARD = "flashCard";

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textViewResult;
    TextView textViewAnswer;
    Button buttonValidate;
    ImageView image;
    int goodReponse = 0;
    int maxQuestion;

    ArrayList<FlashCard> arrayListFlashCard;
    private int flashCardIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        RadioGroup radioGroupId = findViewById(R.id.radioGroup);
       // int radioButtonsCount = radioGroupId.getChildCount();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        arrayListFlashCard = getIntent().getParcelableArrayListExtra(EXTRA_LISTFLASHCARD);

        flashCardIndex = getIntent().getIntExtra(EXTRA_FLASHCARD, 0);

        goodReponse = getIntent().getIntExtra("goodReponse", 0);
        maxQuestion = getIntent().getIntExtra("maxQuestions" , 0);


        setTitle("Flash Card  " + (flashCardIndex + 1) + " / " + arrayListFlashCard.size());

        final FlashCard flashCard = arrayListFlashCard.get(flashCardIndex);

        final RadioButton radiobutton1 = findViewById(R.id.firstRadioButton);
        RadioButton radiobutton2 = findViewById(R.id.secondRadioButton);
        RadioButton radiobutton3 = findViewById(R.id.thirdRadioButton);

        ImageButton image = findViewById(R.id.imageButton);
        image.setImageResource(flashCard.flagId);

        Collections.shuffle(flashCard.reponse);

        //int a = (int) (Math.random() * 10);
        radiobutton1.setText(flashCard.reponse.get(0));

        //int b = (int) (Math.random() * 10);
        radiobutton2.setText(flashCard.reponse.get(1));

        //final int c = (int) (Math.random() * 10);
        radiobutton3.setText(flashCard.reponse.get(2));



        radioGroup = findViewById(R.id.radioGroup);
        textViewResult = findViewById(R.id.textViewResult);
        textViewAnswer = findViewById(R.id.textViewAnswer);
        buttonValidate = findViewById(R.id.buttonValidate);

        final View thumb1View = findViewById(R.id.imageButton);
        thumb1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ImageView image = (ImageView) findViewById(R.id.imageButton);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(GameActivity.this, BigImageActivity.class);

                        intent.putExtra("drawable", flashCard.flagId);
                        startActivity(intent);
                    }
                });
            }
        });

        final Button buttonValidate = findViewById(R.id.buttonValidate);
        buttonValidate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("mes", buttonValidate.getText().toString());

                if (buttonValidate.getText().equals("Valider la réponse")) {
                    Log.i("mes", "messagefzfzefr");
                    int radioId = radioGroup.getCheckedRadioButtonId();

                    radioButton = findViewById(radioId);

                    textViewResult.setText("your choice : " + radioButton.getText());

                    if (radioButton.getText().equals(flashCard.oneReponse)) {
                        textViewResult.setText("Bonne réponse " + flashCard.oneReponse);
                        textViewAnswer.setText("");

                        textViewResult.setTextColor(Color.GREEN);

                        goodReponse++;


                        buttonValidate.setText("Prochaine question");


                    } else {
                        textViewResult.setText("Mauvaise réponse ");
                        textViewAnswer.setText("La bonne réponsé était " + flashCard.oneReponse);

                        textViewResult.setTextColor(Color.RED);


                        buttonValidate.setText("Prochaine question");
                    }


                    if(flashCardIndex == 1)
                    {
                        buttonValidate.setText("Voir les résultats");
                        Log.i("jFDHJFHDFJDH", "onClick: OK JE SUIS DANS LE TRUC");

                        Intent intent = new Intent(GameActivity.this, ResultsActivity.class);

                        intent.putExtra("goodReponse", goodReponse );
                        intent.putExtra("maxQuestions", arrayListFlashCard.size());

                        startActivity(intent);



                    }
                } else if (buttonValidate.getText().equals("Prochaine question")) {
                    //FlashCard flashCard = new FlashCard(R.drawable.ark_logo, "ark", list);

                    Intent intent = new Intent(GameActivity.this, GameActivity.class);

                    //intent.putExtra("countAnswer", countAnswer++);
                    flashCardIndex++;

                    intent.putExtra(GameActivity.EXTRA_LISTFLASHCARD, arrayListFlashCard);

                    intent.putExtra(GameActivity.EXTRA_FLASHCARD, flashCardIndex);

                    startActivity(intent);
                }


        }
    });


    }
/* just for showing your choice
  public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected btn : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    } */

}
