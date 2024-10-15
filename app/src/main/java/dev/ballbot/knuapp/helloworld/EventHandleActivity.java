package dev.ballbot.knuapp.helloworld;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EventHandleActivity extends AppCompatActivity implements View.OnTouchListener {
    private Button redButton = null;
    private Button greenButton = null;
    private LinearLayout logView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handle);

        this.redButton = findViewById(R.id.redButton);
        this.greenButton = findViewById(R.id.greenButton);
        this.logView = findViewById(R.id.logView);
        this.redButton.setOnTouchListener(this);
        this.greenButton.setOnTouchListener(this);
    }

    private void addLog(String msg) {
        TextView view = new TextView(this);
        view.setText(msg);
        this.logView.addView(view);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        String color = v.getId() == R.id.greenButton ? "초록" : "빨강";

        switch (action) {
            case MotionEvent.ACTION_DOWN -> addLog(color + "버튼 손가락 누름, " + x + ", " + y);
            case MotionEvent.ACTION_MOVE -> addLog(color + "버튼 손가락 움직임, " + x + ", " + y);
            case MotionEvent.ACTION_UP -> addLog(color + "버튼 손가락 땜" + x + ", " + y);
        }

        return true;
    }
}