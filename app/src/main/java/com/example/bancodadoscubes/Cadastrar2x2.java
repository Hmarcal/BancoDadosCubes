package com.example.bancodadoscubes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar2x2 extends AppCompatActivity {
    
    private Button btnCadastra2x2;
    private EditText tempoCb2x2;
    private Contagem2x2 TempoCRONO;
    
    private Cube2x2DB db;
    
    
   
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar2x2);
        
        db = new Cube2x2DB(this);
        btnCadastra2x2 = findViewById(R.id.cadastra2x2XML);
        tempoCb2x2 = findViewById(R.id.tempo2x2XML);
        
        
        btnCadastra2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tempoCb2x2.getText().length() == 0){
                    Toast.makeText(Cadastrar2x2.this, "Por favor preencha o tempo!",Toast.LENGTH_SHORT).show();
                }else {
                    
                   String temp2x2 = tempoCb2x2.getText().toString();

                   
                   Cube2x2 cadastro2x2 = new Cube2x2(0,temp2x2);
                   
                   long id = db.salva2x2(cadastro2x2);
                   if (id != -1)
                       Toast.makeText(Cadastrar2x2.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();
                   else
                       Toast.makeText(Cadastrar2x2.this,"Ops! Não foi possível salvar o tempo.", Toast.LENGTH_LONG).show();
                   
                   tempoCb2x2.setText("");
                }
            }
        });


    }
}