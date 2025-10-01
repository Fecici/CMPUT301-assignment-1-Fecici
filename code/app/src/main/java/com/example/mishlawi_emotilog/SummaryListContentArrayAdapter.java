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

public class SummaryListContentArrayAdapter extends ArrayAdapter<EmoteCount> {

    public SummaryListContentArrayAdapter(Context context, ArrayList<EmoteCount> emotes) {
        super(context, 0, emotes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null) {  // convert view is a reused view, to save resources
            // create new view using layout inflater if no recyclable view available

            view = LayoutInflater.from(getContext()).inflate(R.layout.summary_emote_list_content, parent, false);
        }
        else {
            // just reuse the garbage view
            view = convertView;
        }

        EmoteCount emoteCount = getItem(position);

        // TODO: format for summary
        // use summarylistcontentarrayadapter for sublist
        TextView emojiView = view.findViewById(R.id.summary_content_emote);
        TextView countView = view.findViewById(R.id.summary_content_count);

        emojiView.setText(emoteCount.getEmote() + ": ");
        countView.setText(emoteCount.getCount().toString());

        return view;
    }
}
