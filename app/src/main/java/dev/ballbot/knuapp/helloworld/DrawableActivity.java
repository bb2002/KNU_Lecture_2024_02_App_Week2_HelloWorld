package dev.ballbot.knuapp.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DrawableActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        findViewById(R.id.firstButton).setOnClickListener(this);
        ImageView secondButton = findViewById(R.id.secondButton);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SecondButtonClicked", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.thirdButton).setOnLongClickListener(v -> {
            Toast.makeText(getApplicationContext(), "ThirdButtonClicked", Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "FirstButtonClicked", Toast.LENGTH_SHORT).show();
    }
}