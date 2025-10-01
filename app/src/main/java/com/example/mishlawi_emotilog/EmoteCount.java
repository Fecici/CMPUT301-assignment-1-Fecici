package com.example.mishlawi_emotilog;

import android.os.Parcel;
import android.os.Parcelable;

public class EmoteCount implements Parcelable {
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
    public Integer getCount() {return this.count;}
    public void incrementCount() {
        this.count++;
    }

    protected EmoteCount(Parcel in) {
        emote = in.readString();
        count = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(emote);
        dest.writeInt(count);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EmoteCount> CREATOR = new Creator<EmoteCount>() {
        @Override
        public EmoteCount createFromParcel(Parcel in) {
            return new EmoteCount(in);
        }

        @Override
        public EmoteCount[] newArray(int size) {
            return new EmoteCount[size];
        }
    };
}
