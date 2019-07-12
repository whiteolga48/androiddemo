package com.mariusapps.pollolokoretrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.mariusapps.pollolokoretrofit.Adaptadores.CamareroListAdapter;
import com.mariusapps.pollolokoretrofit.Adaptadores.ProductosListAdapter;
import com.mariusapps.pollolokoretrofit.JsonPlaceHolderApi;
import com.mariusapps.pollolokoretrofit.R;
import com.mariusapps.pollolokoretrofit.model.Camarero;
import com.mariusapps.pollolokoretrofit.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadosGenerales extends AppCompatActivity {

    JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listados_generales);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        Call<List<Camarero>>call = jsonPlaceHolderApi.getCamareros();

        call.enqueue(new Callback<List<Camarero>>() {
            @Override
            public void onResponse(Call<List<Camarero>> call, Response<List<Camarero>> response) {

                if (!response.isSuccessful())

                {return;}

                List<Camarero> camareros = response.body();
                camareroListar(camareros);


            }

            @Override
            public void onFailure(Call<List<Camarero>> call, Throwable t) {

            }
        });






    }




    private void camareroListar (List<Camarero>camareros){




        ListView listaCamareros;
        listaCamareros = findViewById(R.id.id_list_view_listados_generales);
        CamareroListAdapter camareroListAdapter = new CamareroListAdapter(this, camareros);
        listaCamareros.setAdapter(camareroListAdapter);


    }


    private void productoListar (List<Producto>productos){


        ListView listaProductos;
        listaProductos = findViewById(R.id.id_list_view_listados_generales);
        ProductosListAdapter productosListAdapter = new ProductosListAdapter(this, productos);
        listaProductos.setAdapter(productosListAdapter);



    }





}
