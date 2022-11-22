package com.example.bancodadoscubes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cronometro2x2 extends AppCompatActivity {

    private TextView timer2x2;
    private Button btnStart2x2;
    private Button btnStop2x2;
    private Button btnSave2x2;

    private Context cContext;
    private Contagem2x2 cContagem2x2;
    private Thread cThreadCrono2x2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro2x2);

        cContext = this;

        timer2x2 = findViewById(R.id.timer2x2XML);
        btnStart2x2 = findViewById(R.id.start2x2XML);
        btnStop2x2 = findViewById(R.id.stop2x2XML);
        btnSave2x2 = findViewById(R.id.save2x2XML);



        btnStart2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cContagem2x2 == null){
                    cContagem2x2 = new Contagem2x2(cContext);
                    cThreadCrono2x2 = new Thread(cContagem2x2);
                    cThreadCrono2x2.start();
                    cContagem2x2.start();
                }

            }
        });

        btnStop2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cContagem2x2 !=null){
                    cContagem2x2.stop();
                    cThreadCrono2x2.interrupt();
                    cThreadCrono2x2 = null;

                    cContagem2x2 = null;
                }
            }
        });

        btnSave2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent save2x2Intent = new Intent(Cronometro2x2.this, Cadastrar2x2.class);
                startActivity(save2x2Intent);
            }
        });

    }

    public void updateTimerText(final String time){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timer2x2.setText(time);
            }
        });

    }




}