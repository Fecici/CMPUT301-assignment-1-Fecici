package com.example.mishlawi_emotilog;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyLogSummary implements Parcelable {

    private Date date;
    private String day;
    private ArrayList<Log> dailyLog;
    private ArrayList<EmoteCount> table = new ArrayList<>();

    public DailyLogSummary(Date date, ArrayList<Log> dailyLog) {

        this.date = date;
        this.dailyLog = dailyLog;

        SimpleDateFormat dayFormat = new SimpleDateFormat("MM/dd");
        day = dayFormat.format(date);

        for (Log log : dailyLog) {
            boolean found = false;
            for (EmoteCount e : table) {
                if (log.getFeeling().getEmoji().equals(e.getEmote())) {
                    e.incrementCount();
                    found = true;
                    break;
                }
            }
            if (!found) {
                table.add(new EmoteCount(log.getFeeling().getEmoji(), 1));
            }
        }

        DEBUG_table();
    }

    private void DEBUG_table() {
        System.out.println("DEBUGGING TABLE...");
        for (EmoteCount e : table) {
            System.out.println("DEBUG: " + e.getEmote() + " " + e.getCount());
        }
    }

    public ArrayList<EmoteCount> getTable() {
        return this.table;
    }

    public String getDay() {return this.day;}

    public Date getDate() {
        return this.date;
    }

    public ArrayList<Log> getDailyLog() {
        return this.dailyLog;
    }

    protected DailyLogSummary(Parcel in) {

        long tmpDate = in.readLong();
        this.date = (tmpDate == -1 ? null : new Date(tmpDate));

        this.day = in.readString();

        this.dailyLog = in.createTypedArrayList(Log.CREATOR);
        this.table = in.createTypedArrayList(EmoteCount.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(date != null ? date.getTime() : -1);

        dest.writeString(day);
        dest.writeTypedList(dailyLog);
        dest.writeTypedList((List) table);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DailyLogSummary> CREATOR = new Creator<DailyLogSummary>() {
        @Override
        public DailyLogSummary createFromParcel(Parcel in) {
            return new DailyLogSummary(in);
        }

        @Override
        public DailyLogSummary[] newArray(int size) {
            return new DailyLogSummary[size];
        }
    };

}
