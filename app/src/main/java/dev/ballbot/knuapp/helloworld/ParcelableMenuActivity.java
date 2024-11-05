package dev.ballbot.knuapp.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dev.ballbot.knuapp.helloworld.serializer.MyParcelable;

public class ParcelableMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_menu);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle b = intent.getExtras();
            MyParcelable data = b.getParcelable("MyData");
            if (data != null) {
                TextView tv = findViewById(R.id.textView);
                tv.setText(data.mData + " -> " + data.mString);
            }
        }

        findViewById(R.id.outout).setOnClickListener(v -> {
            finish();
        });
    }
}