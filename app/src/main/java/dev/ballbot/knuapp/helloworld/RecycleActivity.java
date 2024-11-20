package dev.ballbot.knuapp.helloworld;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        RecyclerView rv = findViewById(R.id.recycleview);
        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layout);
        PersonAdapter adap = new PersonAdapter();
        adap.persons.add(new MyPerson("볼봇", "010-1111-2222"));
        adap.persons.add(new MyPerson("에그봇", "010-2222-3333"));
        adap.persons.add(new MyPerson("글라도스", "010-4444-5555"));
        rv.setAdapter(adap);
    }
}