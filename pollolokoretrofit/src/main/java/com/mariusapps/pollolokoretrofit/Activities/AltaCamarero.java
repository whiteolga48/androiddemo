package com.mariusapps.pollolokoretrofit.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mariusapps.pollolokoretrofit.JsonPlaceHolderApi;
import com.mariusapps.pollolokoretrofit.MainActivity;
import com.mariusapps.pollolokoretrofit.R;
import com.mariusapps.pollolokoretrofit.model.Camarero;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AltaCamarero extends AppCompatActivity {

    Button btn_crear_camarero;
    private JsonPlaceHolderApi  jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_camarero);

        btn_crear_camarero = findViewById(R.id.idButtonCrearCamarero);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create((JsonPlaceHolderApi.class));

       btn_crear_camarero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent intent = new Intent(AltaCamarero.this, CamarerosLista.class);

             createCamarero();

            }
        });

    }
       private void createCamarero(){

           Camarero newCamarero = new Camarero();

           int codigo = (int)(Math.random()*100000);
           newCamarero.setCodigo((long) codigo);
           newCamarero.setNombre("Nombre : " + codigo);
           Call<Camarero> call = jsonPlaceHolderApi.create(newCamarero);
           call.enqueue(new Callback<Camarero>() {
               @Override
               public void onResponse(Call<Camarero> call, Response<Camarero> response) {

                   if (!response.isSuccessful()){
                       return;
                   }

                   Log.d("***",response.toString());
                   Intent intent = new Intent(AltaCamarero.this, CamarerosLista.class);

                   startActivity(intent);

               }

               @Override
               public void onFailure(Call<Camarero> call, Throwable t) {

               }
           });




       }


}
