package dev.ballbot.knuapp.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivityActivity extends AppCompatActivity {
    private LayoutInflater inflater = null;
    private LinearLayout containerLayout = null;
    private Button addButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);

        this.inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        this.containerLayout = findViewById(R.id.happy_container);
        this.addButton = findViewById(R.id.addActivityButton);
        this.addButton.setOnClickListener(v -> {
            View view = inflater.inflate(R.layout.bubun, this.containerLayout, false);
            CheckBox box = view.findViewById(R.id.bubun_checkbox);
            box.setText("로드됨");
            box.setChecked(true);

            this.containerLayout.addView(view);
        });

        findViewById(R.id.getout).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("message", "Welcome to the aperture");
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}