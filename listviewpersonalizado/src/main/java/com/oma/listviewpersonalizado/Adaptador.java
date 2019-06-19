package com.oma.listviewpersonalizado;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import static com.oma.listviewpersonalizado.R.layout.item_listview;

public class Adaptador extends BaseAdapter {


    private  LayoutInflater inflater = null;

    Context context;
    String [][] datos;
    int [] datosImg;


    public Adaptador(Context context, String[][] datos, int[] imagenes) {
        this.context = context;
        this.datos = datos;
        this.datosImg = imagenes;
        inflater =(LayoutInflater) context.getSystemService( context.LAYOUT_INFLATER_SERVICE );
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

         final View vista = inflater.inflate( item_listview,null );
        TextView titulo = (TextView) vista.findViewById(R.id.tv_titulo);
        TextView duracion = (TextView) vista.findViewById(R.id.tv_duracion);
        TextView director = (TextView) vista.findViewById(R.id.tvdirector);

        ImageView imagen = (ImageView) vista.findViewById(R.id.imageView);
        RatingBar calificacion = (RatingBar) vista.findViewById(R.id.rb1);

        titulo.setText( datos[i][0] );
        director.setText( datos[i][1] );
        duracion.setText("Duración " + datos[i] [2]);
        imagen.setImageResource( datosImg[i] );
        calificacion.setProgress( Integer.valueOf( datos[i] [3]) );



        imagen.setTag( i ); // cuando hacemos click saber la posición



        imagen.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // le paso un obejeto de la clase class VisorImagen.class

                // Class clase = String.class;

                // putExtra método sobrecargado;


                Intent visorImagen = new Intent( context,VisorImagen.class );
                visorImagen.putExtra( "IMG",datosImg[(Integer)v.getTag()]);

                // datos img es el array

                context.startActivity(visorImagen);
            }
        } );







        return vista;
    }


    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
