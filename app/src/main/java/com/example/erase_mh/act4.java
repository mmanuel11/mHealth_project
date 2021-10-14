package com.example.erase_mh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class act4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act4);

        Bundle datos = getIntent().getExtras();
        int scoreSection1 = datos.getInt("section1");



        findViewById(R.id.button_irenfemerdadesFact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 =  new Intent(getApplicationContext(),act5.class);

                intent3.putExtra("section1",scoreSection1);

                startActivity(intent3);
            }
        });
    }
}