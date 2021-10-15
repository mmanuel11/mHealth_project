package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UmbralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umbral);

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

                startActivity(intentScore);
            }
        });

    }
}