package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class act7 extends AppCompatActivity {

    private Spinner spinnerCirugia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act7);

        Bundle datos = getIntent().getExtras();
        int scoreSection1 = datos.getInt("section1");
        int scoreSection2 = datos.getInt("section2");

        findViewById(R.id.button_siguiMents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // extraccioin edit number
                EditText tiemposala = findViewById(R.id.editTextNumber_sala);
                EditText tiempoespera = findViewById(R.id.editTextNumber_espera);
                EditText uci = findViewById(R.id.editTextNumber_postoperat);
                EditText sangreAnticipada = findViewById(R.id.editTextNumber_postoperat2);
                EditText equipo = findViewById(R.id.editTextNumber_postoperat3);
                EditText intubacion =  findViewById(R.id.editTextNumber_postoperat4);

                String numero_tiempoSala = tiemposala.getText().toString();
                int int_tiempoSala = Integer.parseInt(numero_tiempoSala);

                String numero_tiempoEspera = tiempoespera.getText().toString();
                int int_tiempoEspera = Integer.parseInt(numero_tiempoSala);

                String numero_uci = uci.getText().toString();
                int int_uci = Integer.parseInt(numero_uci);

                String numero_sangreAnticipada = sangreAnticipada.getText().toString();
                int int_sangreAnticipada = Integer.parseInt(numero_sangreAnticipada);

                String numero_equipo = equipo.getText().toString();
                int int_equipo = Integer.parseInt(numero_equipo);

                String numero_intubacion = intubacion.getText().toString();
                int int_intubacion = Integer.parseInt(numero_intubacion);
                //
                int score_sala = 0;
                int score_espera = 0;
                int score_uci = 0;
                int score_sangre = 0;
                int score_equipo = 0;
                int score_intubacion = 0;

                score_sala = salaMethod(int_tiempoSala);
                score_espera = esperaMethod(int_tiempoEspera);
                score_uci = uciMethod(int_uci);
                score_sangre = bloodMethod(int_sangreAnticipada);
                score_equipo = surgicalTeamsizeMethod(int_equipo);
                score_intubacion = intubacionMethod(int_intubacion);

                // sitio cirugia
                Spinner cirugiaSpinner = findViewById(R.id.id_spinnerCirugia);
                String text_spinCirugia = cirugiaSpinner.getSelectedItem().toString();
                int scoreofCirugia = cirugiaMethod(text_spinCirugia);
                //

                int terceraScoreFInal = (score_sala+score_espera+score_uci+score_sangre+score_equipo+score_intubacion+scoreofCirugia);


                Intent intent6 = new Intent(getApplicationContext(),UmbralActivity.class);

                intent6.putExtra("section1",scoreSection1);
                intent6.putExtra("section2",scoreSection2);
                intent6.putExtra("section3",terceraScoreFInal);

                startActivity(intent6);
            }
        });

        spinnerCirugia = findViewById(R.id.id_spinnerCirugia);
        String[] spinOptionC = getResources().getStringArray(R.array.spinnerOptionCirugia);
        ArrayAdapter adapterc = new ArrayAdapter(this, android.R.layout.simple_spinner_item,spinOptionC);
        adapterc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCirugia.setAdapter(adapterc);

    }
    // Métodos para puntación primera parte
    public static int salaMethod (int sala) {
        int resultado = 1;
        if (sala<30){
            resultado = 1;
        }
        else if(sala>30 & sala<=60){
            resultado = 2;
        }
        else if(sala>60 & sala<=120){
            resultado = 3;
        }
        else if(sala>120 & sala<=180){
            resultado = 4;
        }
        else if(sala > 180){
            resultado = 5;
        }

        return resultado;
    }
    public static int esperaMethod (int espera) {
        int resultado = 1;
        if (espera==0){
            resultado = 1;
        }
        else if(espera>0 & espera<23){
            resultado = 2;
        }
        else if(espera>23 & espera<=48){
            resultado = 3;
        }
        else if(espera>48 & espera<=72){
            resultado = 4;
        }
        else if(espera > 72){
            resultado = 5;
        }

        return resultado;
    }
    public static int uciMethod (int uci) {
        int resultado = 1;
        if (uci<0){
            resultado = 1;
        }
        else if(uci>0 & uci<=5){
            resultado = 2;
        }
        else if(uci>5 & uci<=10){
            resultado = 3;
        }
        else if(uci>10 & uci<=25){
            resultado = 4;
        }
        else if(uci > 25){
            resultado = 5;
        }

        return resultado;
    }
    public static int bloodMethod (int blood) {
        int resultado = 1;
        if (blood<100){
            resultado = 1;
        }
        else if(blood>100 & blood<=250){
            resultado = 2;
        }
        else if(blood>250 & blood<=500){
            resultado = 3;
        }
        else if(blood>500 & blood<=750){
            resultado = 4;
        }
        else if(blood > 750){
            resultado = 5;
        }

        return resultado;
    }
    public static int surgicalTeamsizeMethod (int size) {
        int resultado = 1;
        if (size==1){
            resultado = 1;
        }
        else if(size==2){
            resultado = 2;
        }
        else if(size==3){
            resultado = 3;
        }
        else if(size==4){
            resultado = 4;
        }
        else if(size > 4){
            resultado = 5;
        }

        return resultado;
    }
    public static int intubacionMethod (int intu) {
        int resultado = 1;
        if (intu<1){
            resultado = 1;
        }
        else if(intu>1 & intu<=5){
            resultado = 2;
        }
        else if(intu>5 & intu<=10){
            resultado = 3;
        }
        else if(intu>10 & intu<=25){
            resultado = 4;
        }
        else if(intu > 25){
            resultado = 5;
        }

        return resultado;
    }
    // Método segunda parte Puntuación
    public static int cirugiaMethod (String cirugia) {
        int scoreCirugia = 1;
        if (cirugia.equals("Ninguno")){
            scoreCirugia = 1;
        }
        else if (cirugia.equals("Abdominopélvico (mínima intervención)")){
            scoreCirugia = 2;
        }
        else if (cirugia.equals("Abdominopélvico (Operación abierta) Infraumbilical")){
            scoreCirugia = 3;
        }
        else if (cirugia.equals("Abdominopélvico (Operación abierta) Supraumbilical")){
            scoreCirugia = 4;
        }
        else if (cirugia.equals("Otorrinolaringología, cirugía de cabeza y cuello")||cirugia.equals("Gastrointestinal superior/torácico")){
            scoreCirugia = 5;
        }
        return scoreCirugia;
    }
}