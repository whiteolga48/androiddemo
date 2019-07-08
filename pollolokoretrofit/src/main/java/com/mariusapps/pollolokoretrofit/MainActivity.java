package com.mariusapps.pollolokoretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mariusapps.pollolokoretrofit.Activities.CamarerosLista;
import com.mariusapps.pollolokoretrofit.model.Camarero;

public class MainActivity extends AppCompatActivity {


     Button btn_camareros;
   // private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            btn_camareros = findViewById(R.id.idBtnCamareros);




            btn_camareros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, CamarerosLista.class);
                startActivity(intent);



            }
        });

   }









     }



