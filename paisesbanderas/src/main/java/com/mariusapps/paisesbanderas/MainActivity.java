package com.mariusapps.paisesbanderas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.mariusapps.paisesbanderas.Adaptadores.AdaptadorPaises;
import com.mariusapps.paisesbanderas.model.Pais;
import com.mariusapps.paisesbanderas.retrofit.ApiRest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.idListView);
        listView.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Log.d("***", "Entramos");
       Pais pais = (Pais)parent.getItemAtPosition(position);

       Log.d("**",pais.toString());

        Bundle myBundle =  new Bundle();
        myBundle.putString("codigo",pais.getAlpha2Code());

        Log.d("**", "Main: " + myBundle.toString());

        Intent intent = new Intent(MainActivity.this, DetallePais.class);
        intent.putExtras(myBundle);
        startActivity(intent);

    }
}
