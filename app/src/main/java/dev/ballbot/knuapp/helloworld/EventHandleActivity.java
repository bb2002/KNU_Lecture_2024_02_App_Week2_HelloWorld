package dev.ballbot.knuapp.helloworld;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EventHandleActivity extends AppCompatActivity implements View.OnTouchListener {
    private Button redButton = null;
    private Button greenButton = null;
    private LinearLayout logView = null;
    private GestureDetector mDetector = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handle);

        this.mDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(@NonNull MotionEvent e) {
                addLog("onDown 호출");
                addLog("  x = " + e.getX());
                addLog("  y = " + e.getY());
                return false;
            }

            @Override
            public void onShowPress(@NonNull MotionEvent e) {
                addLog("onShowPress 호출");
                addLog("  x = " + e.getX());
                addLog("  y = " + e.getY());
            }

            @Override
            public boolean onSingleTapUp(@NonNull MotionEvent e) {
                addLog("onSingleTapUp 호출");
                addLog("  x = " + e.getX());
                addLog("  y = " + e.getY());
                return false;
            }

            @Override
            public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
                addLog("onScroll 호출");
                addLog("  x = " + e1.getX());
                addLog("  y = " + e1.getY());
                return false;
            }

            @Override
            public void onLongPress(@NonNull MotionEvent e) {
                addLog("onLongPress 호출");
                addLog("  x = " + e.getX());
                addLog("  y = " + e.getY());
            }

            @Override
            public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
                addLog("onFling 호출");
                addLog("  x = " + e1.getX());
                addLog("  y = " + e1.getY());
                return false;
            }
        });

        this.redButton = findViewById(R.id.redButton);
        this.greenButton = findViewById(R.id.greenButton);
        this.logView = findViewById(R.id.logView);
        this.redButton.setOnTouchListener(this);
        this.greenButton.setOnTouchListener((v, event) -> {
           this.mDetector.onTouchEvent(event);
           return true;
        });
    }

    private void addLog(String msg) {
        TextView view = new TextView(this);
        view.setText(msg);
        this.logView.addView(view);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK -> Toast.makeText(getApplicationContext(), "시스템 Back 버튼 터치 (1)", Toast.LENGTH_SHORT).show();
        }

        return false;
        // 호출 시 앱이 꺼져버림
        // return super.onKeyDown(keyCode, event);
    }

    /*
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "시스템 Back 버튼 터치 (2)", Toast.LENGTH_SHORT).show();
    }
    */

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();

        switch (action) {
            case MotionEvent.ACTION_DOWN -> addLog("버튼 손가락 누름, " + x + ", " + y);
            case MotionEvent.ACTION_MOVE -> addLog("버튼 손가락 움직임, " + x + ", " + y);
            case MotionEvent.ACTION_UP -> addLog("버튼 손가락 땜" + x + ", " + y);
        }

        return true;
    }
}