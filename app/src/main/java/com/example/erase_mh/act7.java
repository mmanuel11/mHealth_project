package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class act7 extends AppCompatActivity {

    private Spinner spinnerCirugia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act7);

        Bundle datos = getIntent().getExtras();
        int score = datos.getInt("lung");

        findViewById(R.id.button_siguiMents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(getApplicationContext(),mentsSCore.class);

                intent6.putExtra("lung",score);

                startActivity(intent6);
            }
        });

        spinnerCirugia = findViewById(R.id.id_spinnerCirugia);
        String[] spinOptionC = getResources().getStringArray(R.array.spinnerOptionCirugia);
        ArrayAdapter adapterc = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinOptionC);
        adapterc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCirugia.setAdapter(adapterc);
    }
}