package dev.ballbot.knuapp.helloworld;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

import dev.ballbot.knuapp.helloworld.fragments.ToolbarFragment1;
import dev.ballbot.knuapp.helloworld.fragments.ToolbarFragment2;
import dev.ballbot.knuapp.helloworld.fragments.ToolbarFragment3;

public class MyToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_toolbar);

        ToolbarFragment1 fgmt1 = new ToolbarFragment1();
        ToolbarFragment2 fgmt2 = new ToolbarFragment2();
        ToolbarFragment3 fgmt3 = new ToolbarFragment3();
        getSupportFragmentManager().beginTransaction().replace(R.id.toolbar_container, fgmt1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();

                switch (pos) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.toolbar_container, fgmt1).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.toolbar_container, fgmt2).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.toolbar_container, fgmt3).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}