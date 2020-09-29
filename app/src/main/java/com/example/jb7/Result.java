package com.example.jb7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView nama = (TextView) findViewById(R.id.nama);
        TextView nim = (TextView) findViewById(R.id.nim);
        TextView date = (TextView) findViewById(R.id.ttl);
        TextView gender = (TextView) findViewById(R.id.gender);
        TextView jurusan = (TextView) findViewById(R.id.jurusan);
        Intent intent = getIntent();
        FomMhs formMhs = intent.getParcelableExtra("Form Mhs");

        nama.setText("Nama:" + formMhs.getNama());
        nim.setText("NIM:" + formMhs.getNim());
        date.setText("Date:" + formMhs.getDate());
        gender.setText("Gender:" + formMhs.getGender());
        jurusan.setText("Jurusan:" + formMhs.getJurusan());
    }
}