package com.example.mishlawi_emotilog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LogContainer {

    private ArrayList<Log> allLogs = new ArrayList<>();
    private ArrayList<DailyLogSummary> dailySummary = new ArrayList<>();  // format from log

    public LogContainer() {
        this.allLogs.clear();
        this.dailySummary.clear();
    }

    public void addLog(Log log) {
        this.allLogs.add(log);
    }

    public ArrayList<Log> getAllLogs() {return this.allLogs;}

    private void updateDailySummary() throws ParseException {

        this.dailySummary.clear();
        ArrayList<Log> temp = new ArrayList<>();
        int i = 0;
        for (Log log : allLogs) {
            Date date = log.getDate();
            temp.add(log);

            if (i > 0 && (date.after(allLogs.get(i).getDate()))) {

                this.dailySummary.add(new DailyLogSummary(date, temp));
                temp.clear();
            }
            i++;
        }
    }

    public ArrayList<DailyLogSummary> getDailySummary() throws ParseException {
        updateDailySummary();
        return this.dailySummary;
    }

}
