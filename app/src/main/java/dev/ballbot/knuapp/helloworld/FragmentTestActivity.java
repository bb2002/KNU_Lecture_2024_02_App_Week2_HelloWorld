package dev.ballbot.knuapp.helloworld;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dev.ballbot.knuapp.helloworld.fragments.MainFragment;
import dev.ballbot.knuapp.helloworld.fragments.MenuFragment;

public class FragmentTestActivity extends AppCompatActivity {
    private MainFragment mainFragment;
    private MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

        this.mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        this.menuFragment = new MenuFragment();
    }

    public void onFragmentChange(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, mainFragment).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, menuFragment).commit();

        }
    }
}