package com.example.bancodadoscubes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Apaga2x2 extends AppCompatActivity {

    private EditText tempoApaga2x2;
    private Button btnApagar2x2;

    private Cube2x2DB db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apaga2x2);

        db = new Cube2x2DB(this);

        tempoApaga2x2 = findViewById(R.id.tempo2x2AXML);
        btnApagar2x2 = findViewById(R.id.apagar2x2AXML);

        btnApagar2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = db.apagar2x2(tempoApaga2x2.getText().toString());
                if (count == 0){
                    Toast.makeText(Apaga2x2.this, "Tempo Inexistente", Toast.LENGTH_SHORT).show();
                    tempoApaga2x2.setText("");
                }else {
                    Toast.makeText(Apaga2x2.this, "Tempo Apagado!", Toast.LENGTH_SHORT).show();
                    tempoApaga2x2.setText("");
                }
            }
        });



    }
}