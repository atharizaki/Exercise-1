package com.example.aplikasitodoappsederhana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_selamatdatang extends AppCompatActivity {

    EditText stask, jtask, jtime;

    FloatingActionButton btnAction;

    TextView sNama;

    String inputNama,inputTask,inputJenis,inputTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selamatdatang);

        stask  = findViewById(R.id.mkTask);
        jtask  = findViewById(R.id.mkJenis);
        jtime  = findViewById(R.id.mkTime);

        btnAction  = findViewById(R.id.fltBtn);

        sNama = findViewById(R.id.TaskNama);

        //penggunaan bundle
        Bundle b = getIntent().getExtras();

        //mendapatkan bundle register
        inputNama = b.getString("r");

        sNama.setText(inputNama);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputTask = stask.getText().toString();
                inputJenis = jtask.getText().toString();
                inputTime = jtime.getText().toString();

                if(inputJenis.length() == 0 && inputTime.length()==0 ){
                    jtask.setError("Jenis Task !!");
                    jtime.setError("Lama Task !!");

                    Toast.makeText(getApplicationContext(), "Data harus terisi semua", Toast.LENGTH_SHORT).show();
                }
                else if(inputTask.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Data harus terisi semua", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();

                    Bundle baru = new Bundle();

                    baru.putString("task", inputTask.trim());
                    baru.putString("jenis", inputJenis.trim());
                    baru.putString("time", inputJenis.trim());

                    Intent Baru = new Intent(getApplicationContext(), activity_hasiltask.class);

                    Baru.putExtras(baru);

                    startActivity(Baru);
                }
            }
        });

    }

    //Option Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi
        if (item.getItemId() == R.id.Submit){

            inputTask = stask.getText().toString();
            inputJenis = jtask.getText().toString();
            inputTime = jtime.getText().toString();

            if(inputJenis.length() == 0 && inputTime.length()==0 ){
                jtask.setError("Jenis Task !!");
                jtime.setError("Lama Task !!");

                Toast.makeText(getApplicationContext(), "Data harus terisi semua", Toast.LENGTH_SHORT).show();
            }
            else if(inputTask.isEmpty()){
                Toast.makeText(getApplicationContext(), "Data harus terisi semua", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();

                Bundle baru = new Bundle();

                baru.putString("task", inputTask.trim());
                baru.putString("jenis", inputJenis.trim());
                baru.putString("time", inputJenis.trim());

                Intent Baru = new Intent(getApplicationContext(), activity_hasiltask.class);

                Baru.putExtras(baru);

                startActivity(Baru);
            }
        }
        else {
            Intent out = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(out);
        }

        return super.onOptionsItemSelected(item);
    }
}