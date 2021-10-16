package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class UmbralActivity extends AppCompatActivity {

    private TextView umbralRango;
    private SeekBar deslizador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umbral);

        umbralRango = findViewById(R.id.id_textViewUmbral);
        deslizador = findViewById(R.id.seekBar);
        deslizador.setProgress(60);
        deslizador.setMax(80);


        Bundle datos = getIntent().getExtras();
        int scoreSection1 = datos.getInt("section1");
        int scoreSection2 = datos.getInt("section2");
        int scoreSection3 = datos.getInt("section3");

        findViewById(R.id.button_sigueRealMents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentScore = new Intent(getApplicationContext(),mentsSCore.class);
                intentScore.putExtra("section1",scoreSection1);
                intentScore.putExtra("section2",scoreSection2);
                intentScore.putExtra("section3",scoreSection3);

                int umbralReal = deslizador.getProgress();
                intentScore.putExtra("Umbral",umbralReal);
                startActivity(intentScore);
            }
        });
        deslizador.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override

            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                umbralRango.setText(String.valueOf(i+25));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}