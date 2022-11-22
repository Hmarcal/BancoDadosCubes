package com.example.bancodadoscubes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExibirTemp2x2 extends AppCompatActivity {

    private ListView minhaLista2x2;

    private ArrayAdapter adapter;

    private static ArrayList<Cube2x2> exibeLista2x2;

    private Cube2x2DB db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_temp2x2);

        db = new Cube2x2DB(this);

        minhaLista2x2 = (ListView)  findViewById(R.id.listView2x2XML);

        exibeLista2x2 = db.findAll();

        adapter = new ArrayAdapter<Cube2x2>(this, android.R.layout.simple_list_item_1,exibeLista2x2);

        minhaLista2x2.setAdapter(adapter);

    }
}