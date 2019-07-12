package com.mariusapps.pollolokoretrofit.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mariusapps.pollolokoretrofit.R;
import com.mariusapps.pollolokoretrofit.model.Camarero;

import java.util.List;
import java.util.PriorityQueue;
import java.util.zip.Inflater;


public class CamareroListAdapter  extends BaseAdapter {


    private LayoutInflater  inflater = null;
    private Context context;
    private List<Camarero> camareros;


    public CamareroListAdapter (Context context, List<Camarero> camareros){

        this.context = context;
        this.camareros = camareros;
        inflater =(LayoutInflater) context.getSystemService( context.LAYOUT_INFLATER_SERVICE );

     }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

           final View vista = inflater.inflate(R.layout.row_model_camarero, null);


       Camarero camarero = camareros.get(position);

       TextView codigo = (TextView) vista.findViewById(R.id.idTvCamareroCodigo);
       TextView nombre = (TextView)  vista.findViewById(R.id.idTvCamareroNombre);



       codigo.setText(String.valueOf(camarero.getCodigo()));
       nombre.setText(String.valueOf(camarero.getNombre()));


        return vista;
    }



    @Override
    public int getCount() {
        return camareros.size();
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
