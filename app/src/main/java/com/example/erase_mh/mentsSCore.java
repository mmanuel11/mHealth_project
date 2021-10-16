package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class mentsSCore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ments_score);
        // Extraccion final scores totales
        Bundle datos = getIntent().getExtras();
        int scoreSection1 = datos.getInt("section1");
        int scoreSection2 = datos.getInt("section2");
        int scoreSection3 = datos.getInt("section3");
        int scoreUmbral   = datos.getInt("Umbral");
        //
        TextView finalscore = findViewById(R.id.id_numberScore);
        int totalScoreFinal = (scoreSection1+scoreSection2+scoreSection3);
        finalscore.setText(""+totalScoreFinal);
        TextView recomendacionFinal = findViewById(R.id.id_alerta);
        recomendacionFinal.setText(recomendacionMethod(scoreUmbral,totalScoreFinal));
        if (recomendacionMethod(scoreUmbral,totalScoreFinal).equals("Es recomendable realizar el procedimiento")){
            recomendacionFinal.setBackgroundColor(Color.parseColor("#A8ED3D"));
        }
        else{
            recomendacionFinal.setBackgroundColor(Color.parseColor("#EC4C33"));
        }
        ProgressBar barGirado = findViewById(R.id.progressBar);
        if(recomendacionMethod(scoreUmbral,totalScoreFinal).equals("Es recomendable realizar el procedimiento")){
            barGirado.setIndeterminateTintList(ColorStateList.valueOf(Color.parseColor("#A8ED3D")));
        }
        else{
            barGirado.setIndeterminateTintList(ColorStateList.valueOf(Color.parseColor("#EC4C33")));
        }


        findViewById(R.id.button_fin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent7);
            }
        });
    }
    public static String recomendacionMethod(int UmbralScore,int scoreTotal){
        String mensaje = "";
        if (scoreTotal <= UmbralScore) {
            mensaje = "Es recomendable realizar el procedimiento";
        }
        else{
            mensaje = "Es arriesgado hacer el procedimiento, revisar los factores involucrados";
        }
        return mensaje;
    }
}