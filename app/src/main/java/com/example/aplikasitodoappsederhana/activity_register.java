package com.example.aplikasitodoappsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class activity_register extends AppCompatActivity {

    TextInputEditText regisNama, regisEmail, regisPass, regisRepass;

    Button btnRegister;

    String nama,email,pass,repass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regisNama   = findViewById(R.id.RegNama);
        regisEmail  = findViewById(R.id.RegEmail);
        regisPass   = findViewById(R.id.RegPass);
        regisRepass = findViewById(R.id.RegRepass);
        btnRegister = findViewById(R.id.btregis);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama   = regisNama.getText().toString();
                email  = regisEmail.getText().toString();
                pass   = regisPass.getText().toString();
                repass = regisRepass.getText().toString();

                if (nama.isEmpty() || email.isEmpty() || pass.isEmpty() || repass.isEmpty()){
                    regisNama.setError("Nama Diperlukan");
                    regisEmail.setError("Email Diperlukan");

                    Toast.makeText(getApplicationContext(), "Semua data harus diisi", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(repass) && nama.equals(nama)){
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();

                        Bundle regis = new Bundle();

                        regis.putString("r", nama.trim());

                        Intent iregis = new Intent(getApplicationContext(), activity_selamatdatang.class);

                        iregis.putExtras(regis);

                        startActivity(iregis);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password dan Re-Password harus sama", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}