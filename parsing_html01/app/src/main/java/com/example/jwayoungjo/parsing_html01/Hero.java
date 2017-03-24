package com.example.jwayoungjo.parsing_html01;

import android.graphics.Bitmap;

/**
 * Created by jwayoung.jo on 2017-03-17.
 */

public class Hero {
    private String Name;
    private int PlayedCount;
    private int Banned;

    private float Popularity;
    private float winning;
    private float Percentage;

    public Hero(String Name, int PlayedCount,  int Banned,
                float Popularity, float winning, float Percentage ) {
        this.Name = Name;
        this.PlayedCount = PlayedCount;
        this.Banned = Banned;
        this.Popularity = Popularity;
        this.winning = winning;
        this.Percentage = Percentage;
    }

    public String getName() {
        return Name;
    }
    public int getPlayedCount() {
        return PlayedCount;
    }
    public int getBanned() {
        return Banned;
    }
    public float getPopularity() {
        return Popularity;
    }
    public float getWinning() {
        return winning;
    }
    public float getPercentage() {
        return Percentage;
    }
}
