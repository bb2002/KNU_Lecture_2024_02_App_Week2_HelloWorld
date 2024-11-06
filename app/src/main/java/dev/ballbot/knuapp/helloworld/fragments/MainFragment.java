package dev.ballbot.knuapp.helloworld.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.ballbot.knuapp.helloworld.FragmentTestActivity;
import dev.ballbot.knuapp.helloworld.R;

public class MainFragment extends Fragment {


    public MainFragment() {
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        rootView.findViewById(R.id.goto_menu_button).setOnClickListener(v -> {
            FragmentTestActivity activity = (FragmentTestActivity) getActivity();
            assert activity != null;
            activity.onFragmentChange(1);
        });
        return rootView;
    }
}