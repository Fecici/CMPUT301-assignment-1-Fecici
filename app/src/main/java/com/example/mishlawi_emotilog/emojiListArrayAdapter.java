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

public class emojiListArrayAdapter extends ArrayAdapter<Feeling> {

    public emojiListArrayAdapter(Context context, ArrayList<Feeling> feelings) {

        super(context, 0, feelings);  // 0 indicates the layout file, means we'll do it later
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null) {  // convert view is a reused view, to save resources
            // create new view using layout inflater if no recyclable view available

            view = LayoutInflater.from(getContext()).inflate(R.layout.emoji_list_content, parent, false);
        }
        else {
            // just reuse the garbage view
            view = convertView;
        }

        Feeling feeling = getItem(position);

        TextView emoji = view.findViewById(R.id.emoji_content);

        // set texts
        emoji.setText(feeling.getEmoji());

        return view;
    }
}
