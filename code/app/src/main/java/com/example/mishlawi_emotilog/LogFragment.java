package com.example.mishlawi_emotilog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mishlawi_emotilog.databinding.LogFragmentBinding;

import java.util.ArrayList;
import java.util.Arrays;


public class LogFragment extends Fragment {
    private LogFragmentBinding binding;
    private Log[] logs;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = LogFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        logs = LogFragmentArgs.fromBundle(getArguments()).getLogs();

        ListView logList = view.findViewById(R.id.log_list);

        ArrayList<Log> logArray = new ArrayList<Log>(Arrays.asList(logs));

        LogArrayAdapter adapter = new LogArrayAdapter(getContext(), logArray);
        logList.setAdapter(adapter);

        Button backButton = view.findViewById(R.id.log_to_main_button);
        backButton.setOnClickListener(v ->
                NavHostFragment.findNavController(LogFragment.this)
                        .navigate(R.id.action_Logs_to_main)
        );


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
