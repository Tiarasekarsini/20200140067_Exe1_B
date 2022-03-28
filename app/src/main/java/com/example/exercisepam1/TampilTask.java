package com.example.exercisepam1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TampilTask extends AppCompatActivity {
    TextView Rtask, Rjenis, Rtime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tampiltask);

        Rtask = findViewById(R.id.rTask);
        Rjenis = findViewById(R.id.rJenis);
        Rtime = findViewById(R.id.rTime);

        Bundle be = getIntent().getExtras();

        String tTask = be.getString("Task");
        String tJenis = be.getString("Jenis");
        String tTime = be.getString("Time");

        Rtask.setText(tTask);
        Rjenis.setText(tJenis);
        Rtime.setText(tTime);
    }
}
