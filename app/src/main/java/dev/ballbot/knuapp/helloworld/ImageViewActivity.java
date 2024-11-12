package dev.ballbot.knuapp.helloworld;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import dev.ballbot.knuapp.helloworld.fragments.ListFragment;
import dev.ballbot.knuapp.helloworld.fragments.ViewFragment;

public class ImageViewActivity extends AppCompatActivity implements ListFragment.ImageSelectionCallback {
  private ViewFragment viewerFragment = null;
  private int[] images = {
      R.drawable.neon,
      R.drawable.clove,
      R.drawable.back_drawable
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_image_view);

    FragmentManager fmgmt = getSupportFragmentManager();
    this.viewerFragment = (ViewFragment) fmgmt.findFragmentById(R.id.viewer_fragment);
  }

  @Override
  public void onImageSelected(int pos) {
    this.viewerFragment.setImage(this.images[pos]);
  }
}