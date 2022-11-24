package com.example.bancodadoscubes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bancodadoscubes.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private Button btn2x2;
    private Button btn3x3;
    private Button btn4x4;
    private Button btn5x5;
    private Button btn6x6;
    private Button btnVisutemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        btn2x2 = (Button) findViewById(R.id.c2x2XML);


        btn2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bt2x2Intent = new Intent(MainActivity.this, Cronometro2x2.class);
                startActivity(bt2x2Intent);
            }
        });

        btn3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bt3x3Intent = new Intent(MainActivity.this, Cronometro2x2.class);
                startActivity(bt3x3Intent);
            }
        });



    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


}