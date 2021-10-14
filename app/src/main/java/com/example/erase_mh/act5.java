package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class act5 extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act5);

        Bundle datos = getIntent().getExtras();
        int score = datos.getInt("lung");

        findViewById(R.id.button_siguiTrata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(),act6.class);

                intent4.putExtra("lung",score);

                startActivity(intent4);
            }
        });

        spinner1 = findViewById(R.id.spinner1);
        String[] spinOption = getResources().getStringArray(R.array.spinnerOption1);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinOption);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner2 = findViewById(R.id.spinner2);
        String[] spinOption2 = getResources().getStringArray(R.array.spinnerOption2);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinOption2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3 = findViewById(R.id.spinner3);
        String[] spinOption3 = getResources().getStringArray(R.array.spinnerOptionFin);
        ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinOption3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);
        spinner6 = findViewById(R.id.spinner6);

        spinner4.setAdapter(adapter3);
        spinner5.setAdapter(adapter3);
        spinner6.setAdapter(adapter3);

    }
}