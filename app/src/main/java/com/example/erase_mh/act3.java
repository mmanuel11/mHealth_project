package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class act3 extends AppCompatActivity {

    private int scoreSection1;

    private int lungdisease =0;
    private int CVdisease = 0;
    private int influenza = 0;

    private int n_asma = 0;
    private int n_EPO = 0;
    private int n_Fibrosis = 0;
    private int n_hiper = 0;
    private int n_insuficiencia = 0;
    private int n_cronica = 0;
    private int n_inmuno = 0;
    private int n_diabetes = 0;
    private int n_apnea = 0;
    private int n_tos = 0;
    private int n_fiebre = 0;
    private int n_garganta =0;
    private int n_diarrea = 0;
    private int n_dolor = 0;


    public static int edadScore (int edad) {
        if (edad<20){
            edad = 1;
        }
        else if (edad>20 & edad<=40){
            edad = 2;
        }
        else if (edad>40 & edad<=50){
            edad = 3;
        }
        else if (edad>50 & edad<=65){
            edad = 4;
        }
        else {
            edad = 5;
        }
        return edad;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        findViewById(R.id.button_Aenfermedad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Condición para lung disease
                if (n_EPO == 1 || n_Fibrosis == 1)
                {
                    lungdisease = 5;
                } else if (n_asma ==1)
                {
                    lungdisease = 4;
                }
                // Condicion para cardiac disease
                CVdisease = n_hiper + n_insuficiencia + n_cronica + 2;
                if (CVdisease >5)
                {
                    CVdisease = 5;
                }
                // Condicion de la edad
                EditText edadUsuario = findViewById(R.id.editTextNumber_edad);
                String edadFinalString = edadUsuario.getText().toString();
                int edadFinalInt = Integer.parseInt(edadFinalString);

                int edadComprobadoFinal = edadScore(edadFinalInt);
                // Condicion de sintomas de influenza
                if ((n_diarrea == 1 || n_dolor == 1 || n_garganta == 1  )&(n_tos == 1 || n_fiebre == 1)){
                    influenza = 5;
                }

                scoreSection1 = (edadComprobadoFinal+lungdisease+CVdisease+n_inmuno+n_diabetes+n_apnea+influenza)/7 ;
                Intent intent2 =  new Intent(getApplicationContext(),act4.class);
                intent2.putExtra("lung",scoreSection1);
                startActivity(intent2);
            }
        });

        CheckBox asma = findViewById(R.id.id_checkAsma);
        CheckBox EPOC = findViewById(R.id.id_checkPulmonar);
        CheckBox fibrosis = findViewById(R.id.id_checkFibrosis);
        CheckBox hipertension = findViewById(R.id.id_checkHiper);
        CheckBox insuficiencia = findViewById(R.id.id_checkInsuficiencia);
        CheckBox coronaria = findViewById(R.id.id_checkCoronaria);
        CheckBox inmuno = findViewById(R.id.id_checkInmuno);
        CheckBox diabetes = findViewById(R.id.id_checkDiabetes);
        CheckBox apnea = findViewById(R.id.id_checkApnea);

        asma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_asma = 1;
                } else {
                    n_asma = 0;
                }
            }
        });
        EPOC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_EPO = 1;
                } else {
                    n_EPO = 0;
                }
            }
        });
        fibrosis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_Fibrosis = 1;
                } else {
                    n_Fibrosis = 0;
                }
            }
        });
        hipertension.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_hiper = 1;
                } else {
                    n_hiper = 0;
                }
            }
        });
        insuficiencia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_insuficiencia = 1;
                } else {
                    n_insuficiencia = 0;
                }
            }
        });
        coronaria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_cronica = 1;
                } else {
                    n_cronica = 0;
                }
            }
        });
        inmuno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_inmuno = 5;
                } else {
                    n_inmuno = 0;
                }
            }
        });
        diabetes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_diabetes = 5;
                } else {
                    n_diabetes = 0;
                }
            }
        });
        apnea.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_apnea = 5;
                } else {
                    n_apnea = 0;
                }
            }
        });
        Switch tos = findViewById(R.id.switchTos);
        Switch fiebre = findViewById(R.id.switchFiebre);
        Switch garganta = findViewById(R.id.switchGarganta);
        Switch diarrea = findViewById(R.id.switchDIarrea);
        Switch dolor = findViewById(R.id.switch6);

        tos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tos.isChecked()) //checking if  switch is checked
                {
                    n_tos = 1;
                } else {
                    n_tos = 0;
                }
            }
        });
        fiebre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tos.isChecked()) //checking if  switch is checked
                {
                    n_fiebre = 1;
                } else {
                    n_fiebre = 0;
                }
            }
        });
        dolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tos.isChecked()) //checking if  switch is checked
                {
                    n_dolor = 1;
                } else {
                    n_dolor = 0;
                }
            }
        });
        diarrea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tos.isChecked()) //checking if  switch is checked
                {
                    n_diarrea = 1;
                } else {
                    n_diarrea = 0;
                }
            }
        });
        garganta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tos.isChecked()) //checking if  switch is checked
                {
                    n_garganta = 1;
                } else {
                    n_garganta = 0;
                }
            }
        });

    }
}