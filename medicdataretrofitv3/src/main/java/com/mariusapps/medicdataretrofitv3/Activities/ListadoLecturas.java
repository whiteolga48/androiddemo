package com.mariusapps.medicdataretrofitv3.Activities;


import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mariusapps.medicdataretrofitv3.Adaptadores.AdaptadorLecturas;
import com.mariusapps.medicdataretrofitv3.JsonPlaceHolderApi;
import com.mariusapps.medicdataretrofitv3.Model.Lectura;
import com.mariusapps.medicdataretrofitv3.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoLecturas extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_lecturas);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://medikdata.herokuapp.com/api/lecturas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Lectura>>call = jsonPlaceHolderApi.getLecturas();

        call.enqueue(new Callback<List<Lectura>>() {

            @Override
            public void onResponse(Call<List<Lectura>> call, Response<List<Lectura>> response) {

                // Aquí entramos cuando llegan los datos

                if(!response.isSuccessful()) {
                    //TODO
                    return;
                }

                List<Lectura> lecturas = response.body();

                ListView listaLecturas = findViewById(R.id.list_view_lecturas);
                AdaptadorLecturas adapter = new AdaptadorLecturas(ListadoLecturas.this, lecturas);
                listaLecturas.setAdapter(adapter);

            }


            @Override
            public void onFailure(Call<List<Lectura>> call, Throwable t) {
                //TODO
            }
        });



    }



}
