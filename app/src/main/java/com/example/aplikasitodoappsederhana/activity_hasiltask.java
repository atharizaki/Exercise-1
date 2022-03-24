package com.example.aplikasitodoappsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity_hasiltask extends AppCompatActivity {

    TextView task, jenis, time;

    String srTask, srJenis, srTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasiltask);

        task    = findViewById(R.id.hslTask);
        jenis   = findViewById(R.id.hslJenis);
        time    = findViewById(R.id.hslTime);

        // Penggunaan Bundle
        Bundle hasil = getIntent().getExtras();

        // Mengambil Bundle dari class selamat datang
        srTask = hasil.getString("task");
        srJenis = hasil.getString("jenis");
        srTime = hasil.getString("time");

        task.setText(srTask);
        jenis.setText(srJenis);
        time.setText(srTime);
    }
}