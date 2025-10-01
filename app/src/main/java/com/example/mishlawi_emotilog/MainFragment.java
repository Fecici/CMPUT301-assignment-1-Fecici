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

public class MainFragment extends Fragment {

    private MainFragmentBinding binding;

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
                        MainFragmentDirections.actionMainToLogs();
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
