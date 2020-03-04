package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textViewResult;
    TextView textViewAnswer;
    Button buttonValidate;
    int goodReponse = 0;

    List<String> list = new ArrayList<String>();


    String goodAnswer = "conterstrike";
    String test = "Valider la réponse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        radioGroup = findViewById(R.id.radioGroup);
        textViewResult = findViewById(R.id.textViewResult);
        textViewAnswer = findViewById(R.id.textViewAnswer);
        buttonValidate = findViewById(R.id.buttonValidate);


        list.add("over");
        list.add("counterstrike");
        list.add("Rocket");
/*      list.add("FF");
        list.add("LOL");
        list.add("Zelda");
        list.add("raimbow");
        list.add("ark");
        list.add("naruto");
        list.add("payday");*/


        final View thumb1View = findViewById(R.id.imageButton);
        thumb1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ImageView image = (ImageView) findViewById(R.id.imageButton);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        image.setImageResource(R.drawable.csgo_logo);
                        ViewGroup.LayoutParams layoutParams = image.getLayoutParams();
                        Log.i("mess", "mess");
                    }
                });
            }
        });

        int a = (int) (Math.random() * 3);

        RadioButton radiobutton1 = findViewById(R.id.firstRadioButton);
        radiobutton1.setText("over");

        int b = (int) (Math.random() * 3);


        RadioButton radiobutton2 = findViewById(R.id.secondRadioButton);
        radiobutton2.setText("conterstrike");

        int c = (int) (Math.random() * 3);


        RadioButton radiobutton3 = findViewById(R.id.thirdRadioButton);
        radiobutton3.setText("rocket");


        //final RadioButton radioFirstButton = findViewById(R.id.radioFirstButton);
        //final RadioButton radioSecondButton = findViewById(R.id.radioSecondButton);
        //final RadioButton radioThirdButton = findViewById(R.id.radioThridButton);

        final Button buttonValidate = findViewById(R.id.buttonValidate);
        buttonValidate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("mes", buttonValidate.getText().toString());

                if (buttonValidate.getText().equals(test)){
                    Log.i("mes", "messagefzfzefr");
                    int radioId = radioGroup.getCheckedRadioButtonId();

                    radioButton = findViewById(radioId);

                    textViewResult.setText("your choice : " + radioButton.getText());

                    if (radioButton.getText().equals(goodAnswer)) {
                        textViewResult.setText("Bonne réponse " + goodAnswer);
                        textViewAnswer.setText("");

                        textViewResult.setTextColor(Color.GREEN);

                        goodReponse++;

                        buttonValidate.setText("Prochaine question");

                    } else {
                        textViewResult.setText("Mauvaise réponse ");
                        textViewAnswer.setText("La bonne réponsé était " + goodAnswer);

                        textViewResult.setTextColor(Color.RED);

                        buttonValidate.setText("Prochaine question");
                    }
                } else if (buttonValidate.getText() == "Prochaine question") {
                    Intent intent = new Intent(GameActivity.this, GameActivity.class);
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