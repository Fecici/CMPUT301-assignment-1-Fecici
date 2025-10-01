package com.example.mishlawi_emotilog;

import static com.example.mishlawi_emotilog.MainActivity.setListViewHeightBasedOnChildren;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.Date;

public class SummaryArrayAdapter extends ArrayAdapter<DailyLogSummary> {


    public SummaryArrayAdapter(Context context, ArrayList<DailyLogSummary> logSummary) {
        super(context, 0, logSummary);
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

        // use summarylistcontentarrayadapter for sublist
        DailyLogSummary dailyLogSummary = getItem(position);

        LinearLayout container = view.findViewById(R.id.emote_container);
        container.removeAllViews(); // clear any recycled children

        LayoutInflater inflater = LayoutInflater.from(getContext());
        System.out.println("HERE 0");
        for (EmoteCount emoteCount : dailyLogSummary.getTable()) {
            System.out.println("HERE" + emoteCount.getEmote() + emoteCount.getCount());
            View row = inflater.inflate(R.layout.summary_emote_list_content, container, false);

            TextView emojiView = row.findViewById(R.id.summary_content_emote);
            TextView countView = row.findViewById(R.id.summary_content_count);

            emojiView.setText(emoteCount.getEmote() + ": ");
            countView.setText(String.valueOf(emoteCount.getCount()));

            container.addView(row);
        }


//        SummaryListContentArrayAdapter innerAdapter = new SummaryListContentArrayAdapter(getContext(), dailyLogSummary.getTable());
//        ListView innerList = view.findViewById(R.id.summary_emote_list);
//        innerList.setAdapter(innerAdapter);
//
//        setListViewHeightBasedOnChildren(innerList);

        TextView dateField = view.findViewById(R.id.summary_day_view);
        String day = dailyLogSummary.getDay();
        dateField.setText(day);



        return view;
    }
}
