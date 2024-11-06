package dev.ballbot.knuapp.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dev.ballbot.knuapp.helloworld.serializer.MyParcelable;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);
    Log.d("KNUAPP", "MainActivity.onCreate()");

    // findViewById(R.id.button).setOnClickListener(v -> {
    //   Toast.makeText(getApplicationContext(), "메롱", Toast.LENGTH_SHORT).show();
    // });
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d("KNUAPP", "MainActivity.onStart()");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d("KNUAPP", "MainActivity.onResume()");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d("KNUAPP", "MainActivity.onStop()");
  }

  public void merong(View view) {
    Intent intent = new Intent(this, ParcelableMenuActivity.class);
    MyParcelable data = new MyParcelable(2147483646, "Welcome to the aperture");
    intent.putExtra("MyData", data);
    startActivityForResult(intent, 0x2000);
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