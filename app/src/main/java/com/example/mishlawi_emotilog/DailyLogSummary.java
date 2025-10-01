package com.example.mishlawi_emotilog;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class DailyLogSummary {

    private Date date;
    private ArrayList<Log> dailyLog;

    public DailyLogSummary(Date date, ArrayList<Log> dailyLog) {

        this.date = date;
        this.dailyLog = dailyLog;
    }

    public Date getDate() {
        return this.date;
    }

    public ArrayList<Log> getDailyLog() {
        return this.dailyLog;
    }

    public ArrayList<EmoteCount> countEmotes() {
        ArrayList<EmoteCount> table = new ArrayList<>();
        for (Log log : dailyLog) {
            for (EmoteCount e : table) {
                if (log.getFeeling().getEmoji().equals(e.getEmote())) {
                    e.incrementCount();
                }
                else {
                    table.add(new EmoteCount(log.getFeeling().getEmoji(), 0));
                }
            }
        }

        return table;
    }
}
