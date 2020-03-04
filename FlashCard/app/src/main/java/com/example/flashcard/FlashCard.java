package com.example.flashcard;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

import java.util.List;

public class FlashCard implements Parcelable{

    @DrawableRes int flagId;
    String oneReponse ;
    List<String> reponse;

//cmd n
    public FlashCard(int flagId, String oneReponse, List<String> reponse) {
        this.flagId = flagId;
        this.oneReponse = oneReponse;
        this.reponse = reponse;
    }

    protected FlashCard(Parcel in) {
        flagId = in.readInt();
        oneReponse = in.readString();
        reponse = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(flagId);
        dest.writeString(oneReponse);
        dest.writeStringList(reponse);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FlashCard> CREATOR = new Creator<FlashCard>() {
        @Override
        public FlashCard createFromParcel(Parcel in) {
            return new FlashCard(in);
        }

        @Override
        public FlashCard[] newArray(int size) {
            return new FlashCard[size];
        }
    };
}
