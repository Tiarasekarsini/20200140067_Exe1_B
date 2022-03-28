package com.example.exercisepam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAkun extends AppCompatActivity {
    //Deklarasi variabel dengan tipe data EditText
    EditText isiNama, isiEmail, isiSandi, isiResandi;

    //Deklarasi variabel dengan tipe data button
    Button btndaftar;

    String sNama, sEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_createakun);

        isiNama = findViewById(R.id.Idnama);
        isiEmail = findViewById(R.id.idEmail);
        isiSandi = findViewById(R.id.IdSandi);
        isiResandi = findViewById(R.id.IdreSandi);
        btndaftar = findViewById(R.id.btnDaftar);

        btndaftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vew) {

                sNama = isiNama.getText().toString();
                sEmail = isiEmail.getText().toString();

                if (sNama.isEmpty() && sEmail.isEmpty()){
                    isiNama.setError("Masukan Nama");
                    isiEmail.setError("Masukan Email");
                }
                else if (isiSandi.getText().toString().equals(isiResandi.getText().toString())) {
                    Toast.makeText(CreateAkun.this, "Pendaftaran Sukses", Toast.LENGTH_SHORT).show();

                    Bundle bl = new Bundle();

                    bl.putString("nm", sNama.trim());

                    Intent i = new Intent(CreateAkun.this, isiTaskActivity.class);
                    i.putExtras(bl);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(CreateAkun.this, "Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
