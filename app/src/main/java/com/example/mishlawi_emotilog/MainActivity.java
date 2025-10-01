package com.example.mishlawi_emotilog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mishlawi_emotilog.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

// https://unicode.org/emoji/charts/full-emoji-list.html   <----- emojis list
public class MainActivity extends AppCompatActivity {

//    private static LogContainer logs = new LogContainer();
//    private Button[] emojiButtons;
//
//    private Feeling[] default_feelings = {
//
//            new Feeling("sad", "\uD83D\uDE22"),
//            new Feeling("annoyed", "\uD83D\uDE44"),
//            new Feeling("disappointed", "\uD83D\uDE12"),
//            new Feeling("bawling", "\uD83D\uDE2D"),
//            new Feeling("happy", "\uD83D\uDE03"),
//            new Feeling("neutral", "\uD83D\uDE10"),
//            new Feeling("angry", "\uD83D\uDE21"),
//            new Feeling("scared", "\uD83D\uDE28"),
//            new Feeling("content", "\uD83D\uDE42"),
//    };
//
//    // since there are always 9 feelings at play at a time, we track current feelings here for customizability
//    private Feeling[] currentFeelings = {
//
//            new Feeling("sad", "\uD83D\uDE22"),
//            new Feeling("annoyed", "\uD83D\uDE44"),
//            new Feeling("disappointed", "\uD83D\uDE12"),
//            new Feeling("bawling", "\uD83D\uDE2D"),
//            new Feeling("happy", "\uD83D\uDE03"),
//            new Feeling("neutral", "\uD83D\uDE10"),
//            new Feeling("angry", "\uD83D\uDE21"),
//            new Feeling("scared", "\uD83D\uDE28"),
//            new Feeling("content", "\uD83D\uDE42"),
//    };

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar));

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment_content_main);
        NavController navController = navHostFragment.getNavController();

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
/*
        // we call these buttons 1-9 because they are customizable. They are ordered as if on a keypad
        Button editEmojiButton = findViewById(R.id.button_change_emoji);


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
                    System.out.println("Button " + (finalI + 1) + " pressed");
                }
            });
        }

        editEmojiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Feeling> feelingArray = new ArrayList<Feeling>(Arrays.asList(currentFeelings));
                new EditEmojiFragment(feelingArray).show(getSupportFragmentManager(), "Edit Emoji");
            }
        });*/


    }
/*
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

    public static LogContainer getLogs() {
        return logs;
    }
*/
}