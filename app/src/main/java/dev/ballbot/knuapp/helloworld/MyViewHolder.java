package dev.ballbot.knuapp.helloworld;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nameView;
    TextView telView;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.nameView = itemView.findViewById(R.id.nameView);
        this.telView = itemView.findViewById(R.id.telView);
        itemView.setOnClickListener(v -> {
            Toast.makeText(itemView.getContext(), "pos = " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        });
    }

    public void setItem(MyPerson item) {
        this.nameView.setText(item.name);
        this.telView.setText(item.mobile);
    }
}
