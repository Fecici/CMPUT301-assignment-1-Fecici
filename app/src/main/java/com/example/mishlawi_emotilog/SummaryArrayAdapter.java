package com.example.mishlawi_emotilog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.net.ContentHandler;
import java.util.ArrayList;

public class SummaryArrayAdapter extends ArrayAdapter<Log> {

    public SummaryArrayAdapter(Context context, ArrayList<Log> logs) {
        super(context, 0, logs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null) {  // convert view is a reused view, to save resources
            // create new view using layout inflater if no recyclable view available

            view = LayoutInflater.from(getContext()).inflate(R.layout.summary_content, parent, false);
        }
        else {
            // just reuse the garbage view
            view = convertView;
        }

        // TODO: format for summary


        return view;
    }
}
