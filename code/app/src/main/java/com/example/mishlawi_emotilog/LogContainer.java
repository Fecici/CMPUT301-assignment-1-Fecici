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

    private void updateDailySummary() {
        this.dailySummary.clear();

        if (allLogs.isEmpty()) return;

        ArrayList<Log> temp = new ArrayList<>();
        Date currentDate = allLogs.get(0).getDate();

        for (Log log : allLogs) {
            Date date = log.getDate();

            // If same day, keep adding
            if (isSameDay(date, currentDate)) {
                temp.add(log);
            } else {
                // new day
                this.dailySummary.add(new DailyLogSummary(currentDate, new ArrayList<>(temp)));
                temp.clear();
                temp.add(log);
                currentDate = date;
            }
        }

        // Add the final batch
        if (!temp.isEmpty()) {
            this.dailySummary.add(new DailyLogSummary(currentDate, new ArrayList<>(temp)));
        }
    }

    private boolean isSameDay(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(d1).equals(fmt.format(d2));
    }

    public ArrayList<DailyLogSummary> getDailySummary() throws ParseException {
        updateDailySummary();
        return this.dailySummary;
    }

}
