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
        Bundle datos = getIntent().getExtras();
        int score = datos.getInt("lung");
        TextView finalscore = findViewById(R.id.id_numberScore);
        finalscore.setText(""+score);
        findViewById(R.id.button_fin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent7);
            }
        });
    }
}