package dev.ballbot.knuapp.helloworld.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import dev.ballbot.knuapp.helloworld.R;

public class ListFragment extends Fragment implements View.OnClickListener {
  private Button selectOneButton;
  private Button selectTwoButton;
  private Button selectThreeButton;

  public static interface ImageSelectionCallback {
    public void onImageSelected(int pos);
  }

  public ImageSelectionCallback callback = null;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
    this.selectOneButton = rootView.findViewById(R.id.select_one_image);
    this.selectTwoButton = rootView.findViewById(R.id.select_two_image);
    this.selectThreeButton = rootView.findViewById(R.id.select_three_image);

    this.selectOneButton.setOnClickListener(this);
    this.selectTwoButton.setOnClickListener(this);
    this.selectThreeButton.setOnClickListener(this);

    return rootView;
  }

  @Override
  public void onClick(View v) {
    if (this.callback == null) return;

    if (v.getId() == R.id.select_one_image) {
      this.callback.onImageSelected(0);
    }

    if (v.getId() == R.id.select_two_image) {
      this.callback.onImageSelected(1);
    }

    if (v.getId() == R.id.select_three_image) {
      this.callback.onImageSelected(2);
    }
  }
}