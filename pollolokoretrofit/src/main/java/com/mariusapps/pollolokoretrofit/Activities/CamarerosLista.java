package com.mariusapps.pollolokoretrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mariusapps.pollolokoretrofit.JsonPlaceHolderApi;
import com.mariusapps.pollolokoretrofit.R;
import com.mariusapps.pollolokoretrofit.model.Camarero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CamarerosLista extends AppCompatActivity  {

    TextView textView;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camareros_lista);
        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        getCamareros();
    }


        public void getCamareros(){

            Call <List<Camarero>> call = jsonPlaceHolderApi.getCamareros();
            call.enqueue(new Callback<List<Camarero>>() {
                @Override
                public void onResponse(Call<List<Camarero>> call, Response<List<Camarero>> response) {


                    if (!response.isSuccessful()){


                        textView.setText("Code: " + response.code());
                        return;
                    }

                }


                List<Camarero> camareros = repo


                @Override
                public void onFailure(Call<List<Camarero>> call, Throwable t) {

                }
            });


        }

}
