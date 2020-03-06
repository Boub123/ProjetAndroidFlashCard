package com.example.flashcard;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.List;

public class CardClass implements Parcelable {
    @DrawableRes int imageId;
    String answer;

    public CardClass(int imageId, String answer){
        this.imageId = imageId;
        this.answer = answer;
    }

    protected CardClass(Parcel in) {
        imageId = in.readInt();
        answer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(answer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CardClass> CREATOR = new Creator<CardClass>() {
        @Override
        public CardClass createFromParcel(Parcel in) {
            return new CardClass(in);
        }

        @Override
        public CardClass[] newArray(int size) {
            return new CardClass[size];
        }
    };

    public int getImageId() { return imageId; }
    public String getAnswer() { return answer; }

    protected static List<Integer> gameImageList(){
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

        return imageList;
    }

    protected static List<String> gameTitleList(){
        List<String> titleList = new ArrayList<>();
        titleList.add("Counter-Strike: Global Offensive");
        titleList.add("Ark");
        titleList.add("League of Legends");
        titleList.add("Overwatch");
        titleList.add("Payday");
        titleList.add("Final Fantasy");
        titleList.add("Naruto");
        titleList.add("Rainbow Six Siege");
        titleList.add("Rocket League");
        titleList.add("Zelda");

        return titleList;
    }

    public static List<CardClass> createCardGameList(){
        List<Integer> imageList = gameImageList();
        List<String> titleList = gameTitleList();

        List<CardClass> cards = new ArrayList<>();
        for (int i = 0; i < imageList.size(); i++){
            // Get the video game picture and its title. Could be improved without a list by using api, database...
            cards.add(new CardClass(imageList.get(i), titleList.get(i)));
        }
        return cards;
    }
}
