package com.example.mishlawi_emotilog;

public class EmoteCount {
    private String emote;
    private int count;

    public EmoteCount(String s, int i) {
        this.emote = s;
        this.count = i;
    }

    public void setEmote(String emote) {
        this.emote = emote;
    }
    public void setCount(int i) {
        this.count = i;
    }

    public String getEmote() {return this.emote;}
    public int getCount() {return this.count;}
    public void incrementCount() {
        this.count++;
    }
}
