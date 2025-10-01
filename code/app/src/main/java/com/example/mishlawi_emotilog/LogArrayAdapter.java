package com.example.mishlawi_emotilog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LogArrayAdapter extends ArrayAdapter<Log> {

    public LogArrayAdapter(Context context, ArrayList<Log> logs) {
        super(context, 0, logs);
    }

    @Override
    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null) {  // convert view is a reused view, to save resources
            // create new view using layout inflater if no recyclable view available

            view = LayoutInflater.from(getContext()).inflate(R.layout.log_content, parent, false);
        } else {
            // just reuse the garbage view
            view = convertView;
        }

        Log log = getItem(position);
        assert log != null;
        String datetime = log.getFullDate();
        Feeling feeling = log.getFeeling();

        String emoji = feeling.getEmoji();
        String mood = feeling.getMood();

        TextView timestamp = view.findViewById(R.id.log_time);
        TextView emojiView = view.findViewById(R.id.log_emoji);
        TextView moodView = view.findViewById(R.id.log_mood);

        timestamp.setText(datetime);
        emojiView.setText(emoji);
        moodView.setText(mood);


        return view;
    }
}
