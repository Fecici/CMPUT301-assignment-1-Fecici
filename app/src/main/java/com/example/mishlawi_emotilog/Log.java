package com.example.mishlawi_emotilog;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
//import java.time.format.DateTimeFormatter;

public class Log {

    private Feeling feeling;
    private String timestamp;
    private String datestamp;
    private String fullDate;
    public Log(Feeling feeling) {
        this.feeling = feeling;

        Date date = new Date();

        SimpleDateFormat fullDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        fullDate = fullDateFormat.format(date);
        timestamp = timeFormat.format(date);
        datestamp = dateFormat.format(date);


    }

    public Feeling getFeeling() {
        return this.feeling;
    }

    public String getFullDate () {return this.fullDate; }
    public String getTimestamp() {return this.timestamp;}
    public String getDatestamp() {return this.datestamp;}
}
