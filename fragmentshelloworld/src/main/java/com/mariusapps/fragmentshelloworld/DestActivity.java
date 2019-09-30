package com.mariusapps.fragmentshelloworld;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.mariusapps.fragmentshelloworld.fragments.AFragment;
import com.mariusapps.fragmentshelloworld.fragments.BFragment;
import com.mariusapps.fragmentshelloworld.fragments.CFragment;


public class DestActivity extends AppCompatActivity implements ComunicaMenu {

    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest);

        fragments = new Fragment[3]; // creamos array de 3 elementos

        // asignamos un Fragment a cada uno de los elementos del array...

        fragments [0] = new  AFragment();

        fragments[1] = new BFragment();
        fragments[2] = new CFragment();

        Bundle extras = getIntent().getExtras();
        // Aquí llega la información de boton_pulsado: 0, 1 o 2
        // Invocamos al método menu y le pasamos el codigo de botón pulsado
        // Recordad que el método menu lo tenemos porque estamos implementando
        // el iterface ComunicaMenu
        menu(extras.getInt("BOTON_PULSADO"));
    }

    @Override
    public void menu(int botonPulsado) {

        FragmentManager fragmentManager = getFragmentManager(); // Ojo importarlo bien!
        // Existe el concepto de transacción!
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // nos pide DÓNDE y QUÉ!
        // 1. identificador del contenedor...
        // 2. el fragmento que queremos cargar... hay tres posibilidades.
        fragmentTransaction.replace(R.id.destino, fragments[botonPulsado]);
        fragmentTransaction.commit();
    }
}