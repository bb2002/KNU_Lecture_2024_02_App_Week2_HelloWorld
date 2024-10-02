package dev.ballbot.knuapp.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FrameLayoutStudy extends AppCompatActivity {
    private ImageView neonView = null;
    private ImageView cloveView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_framelayout);

        this.neonView = findViewById(R.id.neon_view);
        this.cloveView = findViewById(R.id.clove_view);

        findViewById(R.id.change).setOnClickListener(i -> {
            this.neonView.setVisibility(
                    this.neonView.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            this.cloveView.setVisibility(
                    this.cloveView.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
        });
    }
}