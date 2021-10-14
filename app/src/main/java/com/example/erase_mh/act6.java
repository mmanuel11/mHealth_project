package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class act6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act6);

        Bundle datos = getIntent().getExtras();
        int score = datos.getInt("section2");

        findViewById(R.id.button_irAprocedi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 =  new Intent(getApplicationContext(),act7.class);

                intent5.putExtra("section2",score);

                startActivity(intent5);
            }
        });
    }
}