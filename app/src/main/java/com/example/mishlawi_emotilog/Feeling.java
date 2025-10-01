package com.example.mishlawi_emotilog;

public class Feeling {

    private String mood;

    private String emoji;

    public Feeling(String mood, String emoji) {
        this.mood = mood;
        this.emoji = emoji;
    }

    public String getEmoji() {return this.emoji;}
    public String getMood() {return this.mood;}

    public void setMood(String mood) {this.mood = mood;}
    public void setEmoji(String emoji) {this.emoji = emoji;}
}
