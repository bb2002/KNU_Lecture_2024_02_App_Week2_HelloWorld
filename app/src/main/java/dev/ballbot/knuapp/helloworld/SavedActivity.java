package dev.ballbot.knuapp.helloworld;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SavedActivity extends AppCompatActivity {
    private EditText editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        this.editor = (EditText) findViewById(R.id.editTextText);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getSharedPreferences("dev.ballbot.knuapp", SavedActivity.MODE_PRIVATE);
        if (pref != null && pref.contains("name")) {
            this.editor.setText(pref.getString("name", "undefined"));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences pref = getSharedPreferences("dev.ballbot.knuapp", SavedActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", this.editor.getText().toString());
        editor.commit();
    }
}