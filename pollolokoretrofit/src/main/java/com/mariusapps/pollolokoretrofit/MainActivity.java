package com.mariusapps.pollolokoretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mariusapps.pollolokoretrofit.Activities.AltaCamarero;
import com.mariusapps.pollolokoretrofit.Activities.AltaProductos;
import com.mariusapps.pollolokoretrofit.Activities.CamarerosLista;
import com.mariusapps.pollolokoretrofit.Activities.ListadosGenerales;
import com.mariusapps.pollolokoretrofit.Activities.PedidosLista;
import com.mariusapps.pollolokoretrofit.Activities.ProductosLista;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {


     Button btn_camareros;
     Button btn_productos;
     Button btn_pedidos;
     Button btn_alta_camareros;
     Button btn_alta_productos;


   // private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            btn_camareros = findViewById(R.id.idBtnCamareros);
            btn_productos = findViewById(R.id.idButtonProductos);
            btn_pedidos = findViewById(R.id.idButtonPedidos);
            btn_camareros.setOnClickListener(this);
            btn_productos.setOnClickListener(this);
            btn_pedidos.setOnClickListener(this);

            btn_alta_camareros = findViewById(R.id.id_btn_alta_camarero);
            btn_alta_productos = findViewById(R.id.idButtonAltaProducto);

            btn_alta_camareros.setOnClickListener(this);
            btn_alta_productos.setOnClickListener(this);







//            btn_camareros.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent intent = new Intent(MainActivity.this, ListadosGenerales.class);
//                startActivity(intent);
//
//
//
//            }
//        });

//
//            btn_productos.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent intent = new Intent(MainActivity.this, ListadosGenerales
//                            .class);
//
//
//
//                    startActivity(intent);
//
//                }
//            });


//            btn_pedidos.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent intent = new Intent(MainActivity.this, PedidosLista.class);
//                    startActivity(intent);
//
//                }
//            });

//            btn_alta_camareros.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent intent = new Intent(MainActivity.this, AltaCamarero.class);
//                    startActivity(intent);
//
//
//                }
//            });
//
//
//            btn_alta_productos.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//                    Intent intent = new Intent(MainActivity.this, AltaProductos.class);
//                    startActivity(intent);
//                }
//            });











   }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.idBtnCamareros:
                Intent intent = new Intent(MainActivity.this, ListadosGenerales.class);
                startActivity(intent);
                break;

            case R.id.idButtonProductos:
                Intent intent2 = new Intent(MainActivity.this, ListadosGenerales
                        .class);
                startActivity(intent2);
                break;

            case R.id.idButtonPedidos:
                Intent intent3 = new Intent(MainActivity.this, PedidosLista.class);
                startActivity(intent3);
                break;

            case R.id.id_btn_alta_camarero:
                Intent intent4 = new Intent(MainActivity.this, AltaCamarero.class);
                startActivity(intent4);
                break;

            case R.id.idButtonAltaProducto:
                Intent intent5 = new Intent(MainActivity.this, AltaProductos.class);
                startActivity(intent5);
                break;

            default:
                break;




    }
        }
}



