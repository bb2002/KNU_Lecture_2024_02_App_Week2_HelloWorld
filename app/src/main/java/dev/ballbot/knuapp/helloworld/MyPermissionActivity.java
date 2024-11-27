package dev.ballbot.knuapp.helloworld;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MyPermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_permission);

        ArrayList<String> targetList = new ArrayList<>();
        String[] perm = {
                READ_EXTERNAL_STORAGE,
                WRITE_EXTERNAL_STORAGE,
        };

        for (int i = 0; i < perm.length; ++i) {
            String currPerm = perm[i];
            int permCheck = ContextCompat.checkSelfPermission(this, currPerm);
            if (permCheck == PERMISSION_GRANTED) {
                Toast.makeText(this, currPerm + " 권한 있음", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, currPerm + " 권한 없음", Toast.LENGTH_SHORT).show();
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, currPerm)) {
                    Toast.makeText(this, currPerm + " 권한 내노세요 젭알", Toast.LENGTH_LONG).show();
                } else {
                    targetList.add(currPerm);
                }
            }
        }

        if (targetList.size() != 0) {
            String[] targets = new String[targetList.size()];
            targetList.toArray(targets);
            ActivityCompat.requestPermissions(this, targets, 101);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 101:
                if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {
                    Toast.makeText(this, "첫 번째 권한 승인!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "첫 번째 권한 거부..", Toast.LENGTH_SHORT).show();
                }
                return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}