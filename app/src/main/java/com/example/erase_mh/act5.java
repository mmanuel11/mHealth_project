package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class act5 extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;

    public static int first (String operative) {
        int scoreOperatorio = 1;
        if (operative.equals("Sin disponibilidad")){
            scoreOperatorio = 1;
        }
        else if (operative.equals("Menos del 40% de disponibilidad")){
            scoreOperatorio = 2;
        }
        else if (operative.equals("Entre 40% a 60% de disponibilidad")){
            scoreOperatorio = 3;
        }
        else if (operative.equals("Entre 61% a 95% de disponibilidad")){
            scoreOperatorio = 4;
        }
        else if (operative.equals("Disponible")){
            scoreOperatorio = 5;
        }

        return scoreOperatorio;
    }

    public static int second (String operative) {
        int scoreOperatorio = 1;
        if (operative.equals("Riesgo extremo")){
            scoreOperatorio = 1;
        }
        else if (operative.equals("Riesgoso")){
            scoreOperatorio = 2;
        }
        else if (operative.equals("Equivalente")){
            scoreOperatorio = 3;
        }
        else if (operative.equals("Mejor")){
            scoreOperatorio = 4;
        }
        else if (operative.equals("Significativamaente mejor")){
            scoreOperatorio = 5;
        }

        return scoreOperatorio;
    }

    public static int last (String operative) {
        int scoreOperatorio = 1;
        if (operative.equals("Significativamente malo")){
            scoreOperatorio = 1;
        }
        else if (operative.equals("Malo")){
            scoreOperatorio = 2;
        }
        else if (operative.equals("Moderadamente malo")){
            scoreOperatorio = 3;
        }
        else if (operative.equals("Ligeramente malo")){
            scoreOperatorio = 4;
        }
        else if (operative.equals("No hay impacto")){
            scoreOperatorio = 5;
        }

        return scoreOperatorio;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act5);

        Bundle datos = getIntent().getExtras();
        int scoreSection1 = datos.getInt("section1");

        findViewById(R.id.button_siguiTrata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // OPERATIVE FIRST
                Spinner j_spin1 = findViewById(R.id.spinner1);
                String text_spin1 = j_spin1.getSelectedItem().toString();
                int operando1 = first(text_spin1);

                // OPERATIVE SECOND
                Spinner j_spin2 = findViewById(R.id.spinner2);
                String text_spin2 = j_spin2.getSelectedItem().toString();
                int operando2 = second(text_spin2);
                // LAS DEMAS OPERATIVE
                Spinner j_spin3 = findViewById(R.id.spinner3);
                String text_spin3 = j_spin3.getSelectedItem().toString();
                int operando3 = last(text_spin3);

                Spinner j_spin4 = findViewById(R.id.spinner4);
                String text_spin4 = j_spin4.getSelectedItem().toString();
                int operando4 = last(text_spin4);

                Spinner j_spin5 = findViewById(R.id.spinner5);
                String text_spin5 = j_spin5.getSelectedItem().toString();
                int operando5 = last(text_spin5);

                Spinner j_spin6 = findViewById(R.id.spinner6);
                String text_spin6 = j_spin6.getSelectedItem().toString();
                int operando6 = last(text_spin6);

                int operativetotal = (operando1+operando2+operando3+operando4+operando5+operando6);


                Intent intent4 = new Intent(getApplicationContext(),act6.class);

                intent4.putExtra("section1",scoreSection1);
                intent4.putExtra("section2",operativetotal);

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