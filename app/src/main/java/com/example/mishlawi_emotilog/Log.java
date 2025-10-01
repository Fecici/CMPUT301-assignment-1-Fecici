package com.example.mishlawi_emotilog;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
//import java.time.format.DateTimeFormatter;

public class Log implements Parcelable {

    private Feeling feeling;
    private String timestamp;
    private String datestamp;
    private String fullDate;
    private Date date;
    public Log(Feeling feeling) {
        this.feeling = feeling;

        date = new Date();

        SimpleDateFormat fullDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
    public Date getDate() {return this.date;}

    protected Log(Parcel in) {
        // Read fields back in same order you wrote them
        feeling = in.readParcelable(Feeling.class.getClassLoader());
        timestamp = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Write fields in order
        dest.writeParcelable(feeling, flags);
        dest.writeString(timestamp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Log> CREATOR = new Creator<Log>() {
        @Override
        public Log createFromParcel(Parcel in) {
            return new Log(in);
        }

        @Override
        public Log[] newArray(int size) {
            return new Log[size];
        }
    };
}
