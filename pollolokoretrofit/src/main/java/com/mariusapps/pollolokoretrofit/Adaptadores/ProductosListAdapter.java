package com.mariusapps.pollolokoretrofit.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mariusapps.pollolokoretrofit.R;

import com.mariusapps.pollolokoretrofit.model.Producto;

import java.util.List;

public class ProductosListAdapter extends BaseAdapter {

    private LayoutInflater inflater = null;
    private Context context;
    private List<Producto> productos;


    public ProductosListAdapter (Context context, List<Producto> productos){

        this.context = context;
        this.productos = productos;
        inflater =(LayoutInflater) context.getSystemService( context.LAYOUT_INFLATER_SERVICE );

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.row_model_producto,null);


        Producto producto = productos.get(position);

        TextView precio = (TextView) vista.findViewById(R.id.idTvPrecioProducro);
        TextView nombre = (TextView)  vista.findViewById(R.id.idTvNombreProducro);
        TextView descripcion = (TextView) vista.findViewById(R.id.idTvDescricionProducro);
        TextView categoria = (TextView) vista.findViewById(R.id.idTvCategoriProducro);


        precio.setText(String.valueOf(producto.getPrecio()));
        nombre.setText(String.valueOf(producto.getNombre()));
        descripcion.setText(String.valueOf(producto.getDescripcion()));
        categoria.setText(String.valueOf(producto.getCategoria()));



        return vista;
    }



    @Override
    public int getCount() {
        return productos.size();
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
