package com.example.flashcard;

public class CardClass {
    int drawableId;
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
    }
}
