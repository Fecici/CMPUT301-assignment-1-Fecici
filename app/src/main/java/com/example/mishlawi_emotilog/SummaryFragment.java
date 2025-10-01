package com.example.mishlawi_emotilog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mishlawi_emotilog.databinding.LogFragmentBinding;
import com.example.mishlawi_emotilog.databinding.SummaryFragmentBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class SummaryFragment extends Fragment {

    private SummaryFragmentBinding binding;
    private DailyLogSummary[] dailyLogSummaries;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = SummaryFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dailyLogSummaries = SummaryFragmentArgs.fromBundle(getArguments()).getLogSummary();

        ArrayList<DailyLogSummary> logsArray = new ArrayList<DailyLogSummary>(Arrays.asList(dailyLogSummaries));

        SummaryArrayAdapter adapter = new SummaryArrayAdapter(getContext(), logsArray);

        ListView weekly = view.findViewById(R.id.weekly_list);
        weekly.setAdapter(adapter);

        Button backButton = view.findViewById(R.id.summary_to_main_button);
        backButton.setOnClickListener(v ->
                NavHostFragment.findNavController(com.example.mishlawi_emotilog.SummaryFragment.this)
                        .navigate(R.id.action_Summary_to_main)
        );


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

