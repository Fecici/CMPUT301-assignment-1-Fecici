package com.example.mishlawi_emotilog;

import android.os.Parcel;
import android.os.Parcelable;

public class Feeling implements Parcelable {

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

    protected Feeling(Parcel in) {
        mood = in.readString();
        emoji = in.readString();
    }

    // stuff to make parsable work
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mood);
        dest.writeString(emoji);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Feeling> CREATOR = new Creator<Feeling>() {
        @Override
        public Feeling createFromParcel(Parcel in) {
            return new Feeling(in);
        }

        @Override
        public Feeling[] newArray(int size) {
            return new Feeling[size];
        }
    };
}
