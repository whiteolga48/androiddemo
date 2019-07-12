package com.mariusapps.medicdataretrofitv3.Adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mariusapps.medicdataretrofitv3.Model.Lectura;
import com.mariusapps.medicdataretrofitv3.R;

import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Callback;

public class ApdatadorLecturas extends BaseAdapter {

//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }



    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    private Context contexto;
    private LayoutInflater inflater = null;
    private List<Lectura> lecturas;

    public ApdatadorLecturas(Callback<List<Lectura>> contexto, List<Lectura> lecturas){


        this.contexto = (Context) contexto;

        inflater = (LayoutInflater) ((Context) contexto).getSystemService(((Context) contexto).LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista =  inflater.inflate(R.layout.item_list_view,null);

        TextView diastolica = (TextView) vista.findViewById(R.id.idDiastolica);
        TextView sistolica =  (TextView) vista.findViewById(R.id.idSistolica);
        TextView peso = (TextView) vista.findViewById(R.id.idPeso);
        TextView fecha = (TextView) vista.findViewById(R.id.idfecha);

        Lectura lectura = lecturas.get(position);

        diastolica.setText(String.valueOf(lectura.getDiastolica()));
        sistolica.setText(String.valueOf(lectura.getSistolica()));
        peso.setText(String.valueOf(lectura.getPeso()));
        //  fecha.setText(sdf.format(lectura.getFechaHora()));



        Log.d("*****", lectura.toString());



        //String date = sdf.format(new Date());






        //

        // String strFecha = sdf.format(lectura.getFechaHora());
        //Log.d("*******",strFecha);

        //fecha.setText(sdf.format(lectura.getFechaHora()));

        //fecha.setText(sdf.format(fecha5));
        //fecha.setText(strFecha);


        //fecha.setText("Hey");



        return vista;


    }




    @Override
    public int getCount() {
        return lecturas.size();
    }



    // devuelve en item (Una lectura de esa posición, devulve siempre un object )
    @Override
    public Object getItem(int position) {
        return null;
    }

    // devuleve la id del item en tipo Long
    @Override
    public long getItemId(int position) {
        return 0;
    }


}

