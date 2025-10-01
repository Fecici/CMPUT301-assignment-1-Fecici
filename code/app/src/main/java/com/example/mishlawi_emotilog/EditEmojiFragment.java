package com.example.mishlawi_emotilog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class EditEmojiFragment extends DialogFragment{

    ArrayList<Feeling> feelings;

    public interface EditEmojiDialogListener {
        public void editFeeling(int position, String mood, String emoji);
    }

    private EditEmojiDialogListener listener;

    public EditEmojiFragment(ArrayList<Feeling> feelings) {
        super();
        this.feelings = feelings;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.edit_emoji_fragment, null);


        EditText emojiText = view.findViewById(R.id.edit_emoji_text);
        EditText emojiMood = view.findViewById(R.id.edit_emoji_mood);
        ListView emojiList = view.findViewById(R.id.edit_emoji_list);

        final int[] selected = {-1};

        emojiListArrayAdapter adapter = new emojiListArrayAdapter(getContext(), feelings);
        emojiList.setAdapter(adapter);
        emojiList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        emojiList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected[0] = position;
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        return builder
                .setView(view)
                .setTitle("Edit a City")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Edit", (dialog, which) -> {
                    String newEmoji = emojiText.getText().toString();
                    String newMood = emojiMood.getText().toString();
                    Feeling newFeeling = new Feeling(newMood, newEmoji);

                    listener.editFeeling(selected[0], newEmoji, newMood);

                })
                .create();
    }
}
