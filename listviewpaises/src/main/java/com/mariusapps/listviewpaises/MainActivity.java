package com.mariusapps.listviewpaises;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    String [][] datos = {




            //{"País","Continente"},
            {"España","Europa"},
            {"China","Asia"},
            {"Vietnam","Asia"},
            {"Bélgica","Europa"},
            {"Marruecos","África"},
            {"Australia","Oceanía"},
            {"NuevaZelanada","Oceanía"},
            {"USA","América"},
            {"México","América"},
            {"Nicaragua","América"},
            {"Rumania","Europa"},
            {"Filipinas","Asia"},
            {"Noruega","Europa"},
            {"Laos","Asia"},
            {"Portugal","Europa"},
            {"Chile","América"},
            {"Alemania","Europa"},
            {"Samoa","Oceanía"},
            {"Fiyi","Oceanía"},
            {"India","Asia"}
    };


    int[] datosImg = {
            R.drawable.espana,
            R.drawable.china,
            R.drawable.vietnam,
            R.drawable.belgica,
            R.drawable.marruecos,
            R.drawable.aus,
            R.drawable.nuevazelanda,
            R.drawable.usa,
            R.drawable.mx,
            R.drawable.nicaragua,
            R.drawable.rumania,
            R.drawable.filipinas,
            R.drawable.noruega,
            R.drawable.laos,
            R.drawable.portugal,
            R.drawable.chile,
            R.drawable.alemania,
            R.drawable.samoa,
            R.drawable.fiji,
            R.drawable.india
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById( R.id.listview1 );

        listview.setAdapter( new Adaptador( this, datos, datosImg ) );
    }
}
