package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class act3 extends AppCompatActivity {

    private int scoreSection1;

    private int lungdisease =0;
    private int CVdisease = 0;
    private int apnea = 0;
    private int diabetes = 0;
    private int influenza = 0;
    private int covidTotal = 0;

    private int n_ningunPulmon = 0;
    private int n_minimoPulmon = 0;
    private int n_mayorPulmon = 0;

    private int n_ningunCardiaco = 0;
    private int n_minimoCardiaco = 0;
    private int n_leveCardiaco = 0;
    private int n_moderadoCardiaco = 0;
    private int n_severoCardiaco = 0;


    private int n_diabetesNinguno = 1;
    private int n_diabetesModerado = 0;
    private int n_diabetesSevero = 0;

    private int n_apneaNo = 0;
    private int n_apneaModerado = 0;
    private int n_apneaCPAC = 0;



    private int n_influenzaSI = 0;
    private int n_influenzaNO = 0;

    private int n_noCOVID = 0;
    private int n_probablenoCOVID = 0;
    private int n_probableCOVID = 0;
    private int n_posibleCOVID = 0;
    private int n_siCOVID= 0;



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
                // Condicion de la edad
                EditText edadUsuario = findViewById(R.id.editTextNumber_edad);
                String edadFinalString = edadUsuario.getText().toString();
                int edadFinalInt = Integer.parseInt(edadFinalString);
                int edadComprobadoFinal = edadScore(edadFinalInt);
                lungdisease = n_ningunPulmon+n_minimoPulmon+n_mayorPulmon;
                CVdisease = n_ningunCardiaco+n_minimoCardiaco+n_leveCardiaco+n_moderadoCardiaco+n_severoCardiaco;
                apnea = n_apneaNo+n_apneaModerado+n_apneaCPAC;
                diabetes = n_diabetesNinguno+n_diabetesModerado+n_diabetesSevero;
                influenza = n_influenzaNO+n_influenzaSI;
                covidTotal = n_noCOVID+n_probablenoCOVID+n_posibleCOVID+n_probableCOVID+n_siCOVID;

                scoreSection1 = (edadComprobadoFinal+lungdisease+CVdisease+apnea+diabetes+influenza+covidTotal) ;
                Intent intent2 =  new Intent(getApplicationContext(),act4.class);
                intent2.putExtra("section1",scoreSection1);
                startActivity(intent2);
            }
        });

        CheckBox ningunPulmon = findViewById(R.id.id_checkNingunPulmon);
        CheckBox minimoPulmon = findViewById(R.id.id_checkMinimoPulmon);
        CheckBox mayorPulmon = findViewById(R.id.id_checkmayorPulmon);

        CheckBox ningunCardiaco = findViewById(R.id.id_checkningunCardiaco);
        CheckBox minimoCardiaco = findViewById(R.id.id_checkIMinimoCardiaco);
        CheckBox leveCardiaco = findViewById(R.id.id_checkleveCardiaco);
        CheckBox moderadoCardiaco = findViewById(R.id.id_checkModeradaCardiaco);
        CheckBox severaCardiaco = findViewById(R.id.id_checkSeveraCardiaco);

        CheckBox diabetesNinguno = findViewById(R.id.id_checkDiabetesNinguno);
        CheckBox diabetesModerado = findViewById(R.id.id_checkDiabetesModerado);
        CheckBox diabetesSevero = findViewById(R.id.id_checkDiabetesSevero);

        CheckBox apneaNo = findViewById(R.id.id_checkApneanotiene2);
        CheckBox apneaModerado = findViewById(R.id.id_checkApneaModerado2);
        CheckBox apneaCPAP = findViewById(R.id.id_checkIApneaUsaCPAP2);

        ningunPulmon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_ningunPulmon = 1;
                } else {
                    n_ningunPulmon = 0;
                }
            }
        });
        minimoPulmon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_minimoPulmon = 4;
                } else {
                    n_minimoPulmon = 0;
                }
            }
        });
        mayorPulmon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_mayorPulmon = 5;
                } else {
                    n_mayorPulmon = 0;
                }
            }
        });
        // Cardiaco
        ningunCardiaco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_ningunCardiaco = 1;
                } else {
                    n_ningunCardiaco = 0;
                }
            }
        });
        minimoCardiaco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_minimoCardiaco = 2;
                } else {
                    n_minimoCardiaco = 0;
                }
            }
        });
        leveCardiaco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_leveCardiaco = 3;
                } else {
                    n_leveCardiaco = 0;
                }
            }
        });
        moderadoCardiaco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_moderadoCardiaco = 4;
                } else {
                    n_moderadoCardiaco = 0;
                }
            }
        });
        severaCardiaco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_severoCardiaco = 5;
                } else {
                    n_severoCardiaco = 0;
                }
            }
        });
        // Diabetes
        diabetesNinguno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_diabetesNinguno = 1;
                } else {
                    n_diabetesNinguno = 0;
                }
            }
        });
        diabetesModerado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_diabetesModerado = 4;
                } else {
                    n_diabetesModerado = 0;
                }
            }
        });
        diabetesSevero.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_diabetesSevero = 5;
                } else {
                    n_diabetesSevero = 0;
                }
            }
        });
        //Apnea
        apneaNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_apneaNo = 1;
                } else {
                    n_diabetesSevero = 0;
                }
            }
        });
        apneaModerado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_apneaModerado = 4;
                } else {
                    n_diabetesSevero = 0;
                }
            }
        });
        apneaCPAP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    n_apneaCPAC = 5;
                } else {
                    n_apneaCPAC = 0;
                }
            }
        });
        //Influenza
        Switch siInfluenza = findViewById(R.id.switchTos);
        Switch noInfluenza = findViewById(R.id.switchFiebre);


        siInfluenza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (siInfluenza.isChecked()) //checking if  switch is checked
                {
                    n_influenzaSI = 5;
                } else {
                    n_influenzaSI = 0;
                }
            }
        });
        noInfluenza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noInfluenza.isChecked()) //checking if  switch is checked
                {
                    n_influenzaNO = 1;
                } else {
                    n_influenzaNO = 0;
                }
            }
        });
        // COVID
        CheckBox noCOVID = findViewById(R.id.id_checkCovidno);
        CheckBox noprobableCOVID = findViewById(R.id.id_checkCovidprobablemeteno);
        CheckBox probableCOVID = findViewById(R.id.id_checkCovidprobable);
        CheckBox posibleCOVID = findViewById(R.id.id_checkCovidposible);
        CheckBox siCOVID = findViewById(R.id.id_checkCovidSi);

        noCOVID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noCOVID.isChecked()) //checking if  switch is checked
                {
                    n_noCOVID = 1;
                } else {
                    n_noCOVID = 0;
                }
            }
        });
        noprobableCOVID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noprobableCOVID.isChecked()) //checking if  switch is checked
                {
                    n_probablenoCOVID = 2;
                } else {
                    n_probablenoCOVID = 0;
                }
            }
        });
        probableCOVID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (probableCOVID.isChecked()) //checking if  switch is checked
                {
                    n_probableCOVID = 4;
                } else {
                    n_probableCOVID = 0;
                }
            }
        });
        siCOVID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (siCOVID.isChecked()) //checking if  switch is checked
                {
                    n_siCOVID = 5;
                } else {
                    n_siCOVID = 0;
                }
            }
        });
        posibleCOVID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (posibleCOVID.isChecked()) //checking if  switch is checked
                {
                    n_posibleCOVID = 3;
                } else {
                    n_posibleCOVID = 0;
                }
            }
        });


    }
}