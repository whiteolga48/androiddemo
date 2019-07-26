package com.mariusapps.paisesbanderas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.mariusapps.paisesbanderas.Adaptadores.AdaptadorPaises;
import com.mariusapps.paisesbanderas.model.Pais;
import com.mariusapps.paisesbanderas.retrofit.ApiRest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.idListView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiRest apiRest = retrofit.create(ApiRest.class);

        Call<List<Pais>> call = apiRest.getAll();

        call.enqueue(new Callback<List<Pais>>() {
            @Override
            public void onResponse(Call<List<Pais>> call, Response<List<Pais>> response) {


                if (! response.isSuccessful()){


                    Log.d("***", "code: " + response.code());
                    return;

                }

                    List<Pais> paises = response.body();

                // Populate data

                // Vamos a instanciar un adapter

                // Vamos a asignar un adaptador a nuestro listview


                AdaptadorPaises adaptadorPaises = new AdaptadorPaises( paises,MainActivity.this);

                listView.setAdapter(adaptadorPaises);



            }

            @Override
            public void onFailure(Call<List<Pais>> call, Throwable t) {





            }
        });






    }
}
