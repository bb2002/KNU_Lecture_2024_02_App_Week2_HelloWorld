package dev.ballbot.knuapp.helloworld.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import dev.ballbot.knuapp.helloworld.R;

public class ViewFragment extends Fragment {
  private ImageView imageView;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    ViewGroup viewRoot = (ViewGroup) inflater.inflate(R.layout.fragment_view, container, false);
    this.imageView = viewRoot.findViewById(R.id.my_image_view);
    return viewRoot;
  }

  public void setImage(int resId) {
    this.imageView.setImageResource(resId);
  }
}