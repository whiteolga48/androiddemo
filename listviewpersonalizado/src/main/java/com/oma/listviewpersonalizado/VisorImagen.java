package com.oma.listviewpersonalizado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class VisorImagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_visor_imagen );


        // receptor de la imagen

        ImageView img = (ImageView) findViewById( R.id.iv_completa );

        // Obtenemos el intent


         Intent intent = getIntent();


         // Los datos extras llegan a través de un bundle
            Bundle b = intent.getExtras();

            // Recoger los datos que nos envía el Intent

            // Utlizar esos datos para mostrar la imagen que corresponda


         // Sólo si el bundle NO es null

         if (b!=null){

             img.setImageResource( b.getInt( "IMG" ) );

         }

    }
}
