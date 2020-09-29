package com.example.jb7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.jurusan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //parcelable
        final EditText nama = (EditText) findViewById(R.id.editTextTextPersonName);
        final EditText nim = (EditText) findViewById(R.id.editTextNumber);
        final EditText date = (EditText) findViewById(R.id.editTextDate);
        final RadioGroup rd = (RadioGroup) findViewById(R.id.radioGroup2);
        int selectedId = rd.getCheckedRadioButtonId();
        final RadioButton selectRd = (RadioButton) findViewById(selectedId);
        Button buttonParcelable = (Button) findViewById(R.id.buttonParcelable);

        buttonParcelable.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FomMhs formmhs = new FomMhs(nama.getText().toString(),
                        nim.getText().toString(), date.getText().toString(),
                        selectRd.getText().toString(), spinner.getSelectedItem().toString()) {
                };

                Intent intent = new Intent(MainActivity.this, Result.class);
                intent.putExtra("Book", formmhs);
                startActivity(intent);
            }
        });
    }

}