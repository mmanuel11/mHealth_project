package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        //
        TextView finalscore = findViewById(R.id.id_numberScore);
        int totalScoreFinal = (scoreSection1+scoreSection2+scoreSection3)/3;
        finalscore.setText(""+totalScoreFinal);
        findViewById(R.id.button_fin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent7);
            }
        });
    }
}