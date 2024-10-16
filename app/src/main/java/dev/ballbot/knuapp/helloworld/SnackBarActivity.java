package dev.ballbot.knuapp.helloworld;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarActivity extends AppCompatActivity {
    private ProgressBar progressBar = null;
    private Button showButton = null;
    private Button closeButton = null;
    private Button snakeButton = null;
    private Button alertButton = null;
    private ProgressDialog dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        this.progressBar = findViewById(R.id.progressBar);
        this.showButton = findViewById(R.id.showButton);
        this.closeButton = findViewById(R.id.closeButton);
        this.snakeButton = findViewById(R.id.snackButton);
        this.alertButton = findViewById(R.id.alertButton);

        this.showButton.setOnClickListener(v -> {
            this.dialog = new ProgressDialog(this);
            this.dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            this.dialog.setMessage("데이터를 확인할까말까??");
            this.dialog.setCancelable(false);
            this.dialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "그만둬!!", (dialog, which) -> {
                dialog.dismiss();
            });
            this.dialog.show();
        });

        this.closeButton.setOnClickListener(v -> {
            this.progressBar.setProgress(
                    this.progressBar.getProgress() + 5
            );

            if (this.progressBar.getProgress() >= 100) {
                this.progressBar.setProgress(0);
            }
        });

        this.snakeButton.setOnClickListener(v -> {
            Snackbar.make(v, "과자", Snackbar.LENGTH_SHORT).show();
        });

        this.alertButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("빠밤");
            builder.setMessage("끌까?");
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setCancelable(false);
            builder.show();
        });
    }
}