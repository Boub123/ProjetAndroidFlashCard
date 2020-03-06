package com.example.flashcard;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

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

     /*   int drawableId;
    String gameName;

    public CardClass(int imageId, String answer)
    {
        drawableId = imageId;
        gameName = answer;
    }

    void setImageId(int c)
    {
        drawableId = c;
    }
    void setGameName(String c)
    {
        gameName = c;
    }

    public int getDrawableId() {
        return drawableId;
    }
    public String getGameName()
    {
        return gameName;
    }*/
}
