package com.example.aplikasitodoappsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //membuat variabel edit text
    TextView reg;

    //Membuat variabel TextEdt
    TextInputEditText TxtEdtNama, TxtEdtPass;

    //Membuat variabel button
    Button btnSignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Memanggil Text input Edit Text
        TxtEdtNama = findViewById(R.id.MasukanNama);
        TxtEdtPass = findViewById(R.id.MasukanPass);

        //Memanggil btnSignin
        btnSignin = findViewById(R.id.buttonSign);

        //Memanggil Id register
        reg = findViewById(R.id.textRegister);

        //fungsi OnClick Text Register
        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), activity_register.class);
                startActivity(i);
            }
        });

        //Fungsi OnClick Button SignIn
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan Input User
                TxtEdtNama.getText().toString();
                TxtEdtPass.getText().toString();

                if (TxtEdtNama.getText().toString().length()==0){
                    TxtEdtNama.setError("Username Diperlukan");
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong ! ! !", Toast.LENGTH_SHORT).show();
                }
                else if(TxtEdtPass.getText().toString().length()==0){
                    Toast.makeText(getApplicationContext(), "Password tidak boleh kosong ! ! !", Toast.LENGTH_SHORT).show();
                }
                else if (TxtEdtNama.getText().toString().equals("Zaki") && TxtEdtPass.getText().toString().equals("1234")){
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}