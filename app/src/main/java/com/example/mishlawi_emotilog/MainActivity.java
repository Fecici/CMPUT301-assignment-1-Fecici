package com.example.mishlawi_emotilog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

// https://unicode.org/emoji/charts/full-emoji-list.html   <----- emojis list
public class MainActivity extends AppCompatActivity implements EditEmojiFragment.EditEmojiDialogListener {

    private LogContainer logs = new LogContainer();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // we call these buttons 1-9 because they are customizable. They are ordered as if on a keypad
        Button editEmojiButton = findViewById(R.id.button_change_emoji);
        Button summaryButton = findViewById(R.id.button_summary);

        // keep track of the feelings in an array ordered the same.
        emojiButtons = new Button[]{
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9)
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
                }
            });
        }

        editEmojiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Feeling> feelingArray = new ArrayList<Feeling>(Arrays.asList(currentFeelings));
                new EditEmojiFragment(feelingArray).show(getSupportFragmentManager(), "Edit Emoji");
            }
        });


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