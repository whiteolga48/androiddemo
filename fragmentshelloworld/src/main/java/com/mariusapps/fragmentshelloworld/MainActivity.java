package com.mariusapps.fragmentshelloworld;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ComunicaMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void menu(int botonPulsado) {

        Intent intent = new Intent(this,DestActivity.class);
        intent.putExtra("BOTON PULSADO", botonPulsado);

        startActivity(intent);

    }
}
