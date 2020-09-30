package com.example.jb7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog picker;
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
//        final RadioGroup rd = (RadioGroup) findViewById(R.id.radioGroup2);
//        final RadioButton selectRd = ((RadioButton)findViewById(rd.getCheckedRadioButtonId()));

        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup2);
        final String radiovalue = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        Button buttonParcelable = (Button) findViewById(R.id.buttonParcelable);
        date.setInputType(InputType.TYPE_NULL);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        buttonParcelable.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FomMhs formmhs = new FomMhs(nama.getText().toString(),
                        nim.getText().toString(), date.getText().toString(),
                        radiovalue, spinner.getSelectedItem().toString()) {
                };

                Intent intent = new Intent(MainActivity.this, Result.class);
                intent.putExtra("Book", formmhs);
                startActivity(intent);
            }
        });
    }

}