package com.example.exercisepam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class isiTaskActivity extends AppCompatActivity {
    //Deklarasi variabel untuk floatingbutton, edittext dan TextView
    EditText isijenis, isitask, isitime;
    FloatingActionButton buttontask;
    TextView tNama;

    //Deklarasi variabel untuk menyimpan Isian task, jenis task dan juga Time task
    String isiTask, isiJenis, isiTime;

    //method untuk menampilkan menu-menu yang ada
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSubmit) {
            //menyimpan inputan isian dari user kedalam variabel isiTask, isiJenis dan isiTime
            isiTask = isitask.getText().toString();
            isiJenis = isijenis.getText().toString();
            isiTime = isitime.getText().toString();

            //Mengecek apakah user sudah mengisi semua yang diperlukan atau belum
            if (isitask.getText().toString().isEmpty() || isijenis.getText().toString().isEmpty() || isitime.getText().toString().isEmpty()) {
                Toast.makeText(isiTaskActivity.this, "Isi Semua Data", Toast.LENGTH_SHORT).show();
            }
            if (isiTask.isEmpty()) {
                isitask.setError("wajib diisi!!");
            } else if (isiJenis.isEmpty()) {
                isijenis.setError("wajib diisi!!");
            } else if (isiTime.isEmpty()) {
                isitime.setError("wajib diisi!!");
            }
            else {
                Toast.makeText(isiTaskActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                Bundle be = new Bundle();
                be.putString("Task", isiTask.trim());
                be.putString("Jenis", isiJenis.trim());
                be.putString("Time", isiTime.trim());

                Intent i = new Intent(isiTaskActivity.this, TampilTask.class);
                i.putExtras(be);
                startActivity(i);
            }
        } else {
            Intent i = new Intent(isiTaskActivity.this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_isitask);

        //Menghubungkan variabel-variabel dengan komponen editext, floatingbutton dan textview yang ada pada layout
        tNama = findViewById(R.id.tvNama);
        isitask = findViewById(R.id.isiTask);
        isijenis = findViewById(R.id.isiJenis);
        isitime = findViewById(R.id.isiTime);
        buttontask = findViewById(R.id.taskButton);

        //membuat objek bundle dan mengambil data yang dikirimkan dari activity sebelumnya
        Bundle bl = getIntent().getExtras();
        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "nm"
        String nama = bl.getString("nm");
        //menampilkan value dari variabel nama kedalam tNama
        tNama.setText(nama);

        buttontask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                isiTask = isitask.getText().toString();
                isiJenis = isijenis.getText().toString();
                isiTime = isitime.getText().toString();

                if (isitask.getText().toString().isEmpty() || isijenis.getText().toString().isEmpty() || isitime.getText().toString().isEmpty()) {
                    Toast.makeText(isiTaskActivity.this, "Isi Semua Data", Toast.LENGTH_SHORT).show();
                }
                if (isiTask.isEmpty()) {
                    isitask.setError("wajib diisi!!");
                } else if (isiJenis.isEmpty()) {
                    isijenis.setError("wajib diisi!!");
                } else if (isiTime.isEmpty()) {
                    isitime.setError("wajib diisi!!");
                }
                else {
                    Toast.makeText(isiTaskActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                    Bundle be = new Bundle();
                    be.putString("Task", isiTask.trim());
                    be.putString("Jenis", isiJenis.trim());
                    be.putString("Time", isiTime.trim());

                    Intent i = new Intent(isiTaskActivity.this, TampilTask.class);
                    i.putExtras(be);
                    startActivity(i);
                }
            }
        });
    }
}

