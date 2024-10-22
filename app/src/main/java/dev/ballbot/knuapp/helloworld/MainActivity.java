package dev.ballbot.knuapp.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);

    // findViewById(R.id.button).setOnClickListener(v -> {
    //   Toast.makeText(getApplicationContext(), "메롱", Toast.LENGTH_SHORT).show();
    // });
  }

  public void merong(View view) {
    Intent intent = new Intent(this, AddActivityActivity.class);
    intent.putExtra("message", "Hello world");
    startActivityForResult(intent, 0x1000);
  }

  public void gotoNaver(View view) {
    Intent naverIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"));
    startActivity(naverIntent);
  }

  public void getTel(View view) {
    Intent telInt = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-4917-4155"));
    startActivity(telInt);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    switch (requestCode) {
      case 0x1000:
        String msg = data.getStringExtra("message");
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
  }
}