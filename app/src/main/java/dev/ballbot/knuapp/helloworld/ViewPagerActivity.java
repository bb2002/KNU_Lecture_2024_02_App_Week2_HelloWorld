package dev.ballbot.knuapp.helloworld;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import dev.ballbot.knuapp.helloworld.fragments.ToolbarFragment1;
import dev.ballbot.knuapp.helloworld.fragments.ToolbarFragment2;
import dev.ballbot.knuapp.helloworld.fragments.ToolbarFragment3;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addItem(new ToolbarFragment1());
        adapter.addItem(new ToolbarFragment2());
        adapter.addItem(new ToolbarFragment3());
        pager.setAdapter(adapter);
    }
}