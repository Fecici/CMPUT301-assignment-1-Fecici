package com.example.mishlawi_emotilog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mishlawi_emotilog.databinding.MainFragmentBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainFragment extends Fragment implements EditEmojiFragment.EditEmojiDialogListener {

    private MainFragmentBinding binding;

    private static LogContainer logs = new LogContainer();
    private Button[] emojiButtons;

    private Feeling[] default_feelings = {

            new Feeling("sad", "\uD83D\uDE22"),
            new Feeling("annoyed", "\uD83D\uDE44"),
            new Feeling("disappointed", "\uD83D\uDE12"),
            new Feeling("bawling", "\uD83D\uDE2D"),
            new Feeling("happy", "\uD83D\uDE03"),
            new Feeling("neutral", "\uD83D\uDE10"),
            new Feeling("angry", "\uD83D\uDE21"),
            new Feeling("scared", "\uD83D\uDE28"),
            new Feeling("content", "\uD83D\uDE42"),
    };

    // since there are always 9 feelings at play at a time, we track current feelings here for customizability
    private Feeling[] currentFeelings = {

            new Feeling("sad", "\uD83D\uDE22"),
            new Feeling("annoyed", "\uD83D\uDE44"),
            new Feeling("disappointed", "\uD83D\uDE12"),
            new Feeling("bawling", "\uD83D\uDE2D"),
            new Feeling("happy", "\uD83D\uDE03"),
            new Feeling("neutral", "\uD83D\uDE10"),
            new Feeling("angry", "\uD83D\uDE21"),
            new Feeling("scared", "\uD83D\uDE28"),
            new Feeling("content", "\uD83D\uDE42"),
    };

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = MainFragmentBinding.inflate(inflater, container, false);
        View fragmentFirstLayout = inflater.inflate(R.layout.main_fragment, container, false);
        return fragmentFirstLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button summaryButton = view.findViewById(R.id.button_summary);
        Button logButton = view.findViewById(R.id.button_log);

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action =
                        MainFragmentDirections.actionMainToLogs(logs.getAllLogs().toArray(new Log[0]));
                NavHostFragment.findNavController(MainFragment.this).navigate(action);
            }
        });

        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action =
                        MainFragmentDirections.actionMainToSummary();
                NavHostFragment.findNavController(MainFragment.this).navigate(action);
            }
        });


        // we call these buttons 1-9 because they are customizable. They are ordered as if on a keypad
        Button editEmojiButton = view.findViewById(R.id.button_change_emoji);


        // keep track of the feelings in an array ordered the same.
        emojiButtons = new Button[]{
                view.findViewById(R.id.button1),
                view.findViewById(R.id.button2),
                view.findViewById(R.id.button3),
                view.findViewById(R.id.button4),
                view.findViewById(R.id.button5),
                view.findViewById(R.id.button6),
                view.findViewById(R.id.button7),
                view.findViewById(R.id.button8),
                view.findViewById(R.id.button9)
        };

        assert emojiButtons.length == default_feelings.length;

        // set buttons (redundant, but this keeps the backend separate from the front end)
        for (int i = 0; i < emojiButtons.length; i++) {
            emojiButtons[i].setText(default_feelings[i].getEmoji());
            int finalI = i;
            emojiButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    logs.addLog(new Log(currentFeelings[finalI]));  // assign each button to a mood in the array.
                    System.out.println("Button " + (finalI + 1) + " pressed");
                }
            });
        }

        editEmojiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Feeling> feelingArray = new ArrayList<Feeling>(Arrays.asList(currentFeelings));
                new EditEmojiFragment(feelingArray).show(getParentFragmentManager(), "Edit Emoji");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void editFeeling(int position, String mood, String emoji) {

        if (mood != null) {
            currentFeelings[position].setMood(mood);
        }
        if (emoji != null) {
            currentFeelings[position].setEmoji(emoji);
            // update button
            emojiButtons[position].setText(emoji);
        }
    }
}
