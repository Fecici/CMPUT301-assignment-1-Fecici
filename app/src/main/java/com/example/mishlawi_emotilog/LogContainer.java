package com.example.mishlawi_emotilog;

import java.util.ArrayList;
public class LogContainer {

    private ArrayList<Log> allLogs = new ArrayList<>();
    private ArrayList<Log> dailySummary = new ArrayList<>();  // format from log

    public LogContainer() {
        this.allLogs.clear();
        this.dailySummary.clear();
    }

    public void addLog(Log log) {
        this.allLogs.add(log);
    }

    public ArrayList<Log> getAllLogs() {return this.allLogs;}

    private void updateDailySummary() {

        //dailySummary.clear();
       // for (log : allLogs) {

        //}
    }

}
