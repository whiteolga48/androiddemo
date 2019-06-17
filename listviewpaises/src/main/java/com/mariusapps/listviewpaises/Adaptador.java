package com.mariusapps.listviewpaises;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class Adaptador extends BaseAdapter {

    private  LayoutInflater inflater = null;

    Context context;
    String [][]datos;
    int [] datosImg;


    public Adaptador(Context context, String[][] datos, int[] imagenes) {
        this.context = context;
        this.datos = datos;
        this.datosImg = imagenes;
        inflater =(LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.item_listview,null);

        TextView pais = (TextView) vista.findViewById(R.id.tv_pais);
        TextView continente = (TextView) vista.findViewById(R.id.tv_continente);

        ImageView imagen = (ImageView) vista.findViewById(R.id.imageView);

        Log.d("************","i: " + i);


        pais.setText( datos[i][0] );
        continente.setText(datos[i][1]);
       imagen.setImageResource( datosImg[i] );

        imagen.setTag( i );

     /*imagen.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent visorImagen = new Intent( context,VisorImagen.class );
                visorImagen.putExtra( "IMG",datosImg[(Integer)v.getTag()]);
                context.startActivity(visorImagen);
            }
        } );*/


        return vista;
    }


    @Override
    public int getCount() {

        Log.d("*******", Arrays.toString(datosImg));
        Log.d("*******", "datosImg.length: " + datosImg.length );
        return datosImg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
