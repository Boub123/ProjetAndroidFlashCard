package com.example.flashcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PopUpButton extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);
        List<String> list = new ArrayList<String>();


        //put a width and height
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8 ),(int)(height*.6));

        //try open layout with radiobutton

        // This will get the radiogroup
        final RadioGroup rGroup = (RadioGroup) findViewById(R.id.radioGroup);
        //final RadioButton facil = findViewById(R.id.radioFacile);
        // This will get the radiobutton in the radiogroup that is checked
        final RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());
        // This overrides the radiogroup onCheckListener
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                checkedRadioButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ArrayList<FlashCard> arrayFlashCard = new ArrayList<>();
                        List<String> list = new ArrayList<>();

                        list.add("ark");
                        list.add("counterstrike");
                        list.add("Rocket");

                        FlashCard flashCard = new FlashCard(R.drawable.ark_logo, "ark", list);

                        arrayFlashCard.add(flashCard);

                         list = new ArrayList<>();

                        list.add("FF");
                        list.add("LOL");
                        list.add("Zelda");


                        flashCard = new FlashCard(R.drawable.final_fantasy_logo, "FF", list);
                        arrayFlashCard.add(flashCard);

                        Intent intent = new Intent(PopUpButton.this, GameActivity.class);

                        intent.putExtra(GameActivity.EXTRA_LISTFLASHCARD, arrayFlashCard);
                        intent.putExtra(GameActivity.EXTRA_FLASHCARD, 0);
                        startActivity(intent);

                    }
                });
                // This puts the value (true/false) into the variable
                //boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                // Changes the textview's text to "Checked: example radiobutton text"
                /*if (isChecked) {
                    //TextView.setText(Integer.parseInt("Checked:" + checkedRadioButton.getText()));
                    checkedRadioButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(PopUpButton.this, GameActivity.class));
                        }
                    });
                }*/
            }
        });
    }
}
