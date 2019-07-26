package com.mariusapps.paisesbanderas.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mariusapps.paisesbanderas.R;
import com.mariusapps.paisesbanderas.model.Pais;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;
import java.util.zip.Inflater;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;


public class AdaptadorPaises extends BaseAdapter {

    private List<Pais> paises;
    private LayoutInflater inflater;


    public AdaptadorPaises(List<Pais> paises, Context context){
        this.paises = paises;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = null;
        vista= inflater.inflate(R.layout.row_pais,null);


        TextView pais = (TextView) vista.findViewById(R.id.idPais);

        ImageView bandera = (ImageView) vista.findViewById(R.id.idBandera);

        TextView capital = (TextView) vista.findViewById(R.id.idCapital);

        TextView poblacion = vista.findViewById(R.id.idPoblacion);

        TextView region = vista.findViewById(R.id.idRegion);
        TextView nombreNativo = vista.findViewById(R.id.idNativeName);


         Pais pais1 = paises.get(position);
         pais.setText(pais1.getName());
         capital.setText(pais1.getCapital());
         poblacion.setText("Población:  " + String.valueOf(pais1.getPopulation()));
         region.setText(pais1.getRegion());
         nombreNativo.setText(pais1.getNativeName());

         Log.d("***","poblacion"+poblacion);

         String imageURL = "https://www.countryflags.io/" + pais1.getAlpha2Code()
        +   "/flat/64.png";

           Picasso
                   .get()

                   .load(imageURL)

                   .placeholder(R.drawable.pc)
                   .into(bandera);

           return vista;
    }


    @Override
    public int getCount() {
        return paises.size();
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
