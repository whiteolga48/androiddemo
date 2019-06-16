package com.oma.listviewpersonalizado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detallespelicula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detallespelicula );

        TextView titulo = findViewById(R.id.tv_detalle_titulo);
        TextView detalles = findViewById( R.id.tv_descripcion );

        Intent intent = getIntent();

        String name;
        Bundle b = intent.getExtras();

        titulo.setText( b.getString( "TIT" ) );
        detalles.setText( b.getString( "DET" ) );


    }
}
