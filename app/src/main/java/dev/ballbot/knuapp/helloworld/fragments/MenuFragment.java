package dev.ballbot.knuapp.helloworld.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.ballbot.knuapp.helloworld.FragmentTestActivity;
import dev.ballbot.knuapp.helloworld.MainActivity;
import dev.ballbot.knuapp.helloworld.R;

public class MenuFragment extends Fragment {
    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_menu, container, false);
        rootView.findViewById(R.id.goto_main_button).setOnClickListener(v -> {
            FragmentTestActivity activity = (FragmentTestActivity) getActivity();
            assert activity != null;
            activity.onFragmentChange(0);
        });
        return rootView;
    }
}