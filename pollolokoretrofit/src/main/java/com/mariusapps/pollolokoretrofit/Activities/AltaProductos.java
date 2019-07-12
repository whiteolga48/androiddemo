package com.mariusapps.pollolokoretrofit.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mariusapps.pollolokoretrofit.JsonPlaceHolderApi;
import com.mariusapps.pollolokoretrofit.R;
import com.mariusapps.pollolokoretrofit.model.Producto;

import java.lang.reflect.Type;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AltaProductos extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    Button btn_crear_Producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_productos);

        btn_crear_Producto = findViewById(R.id.idButtonCrearProducto);


        btn_crear_Producto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                GsonBuilder builder;
                builder = new GsonBuilder();

                builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                    @Override
                    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        long millisecons = json.getAsJsonPrimitive().getAsLong();
                        return new Date(millisecons);
                    }
                });

                builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
                    @Override
                    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                        long l = src.getTime();
                        return new JsonPrimitive(l);
                    }
                });

                Gson gson = builder.create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://pedi-gest.herokuapp.com/api/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                Producto producto;
                producto = new Producto();

                int codigo = (int)(Math.random() * 1000000000);

                producto.setCodigo((long) codigo);
                producto.setNombre("producto_PRUEBA" + codigo);
                producto.setDescatalogado(false);
                producto.setDescripcion("descripción_LALLLLLLL" + codigo);
                producto.setFechaAlta(new Date());
                producto.setPrecio(999.0);
                producto.setCategoria("COMIDA");

                jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

                Call<Producto> call = jsonPlaceHolderApi.create(producto);

                Log.d("****", "onClick: " + producto);


                Intent intent = new Intent(AltaProductos.this, ProductosLista.class);



            }





        });

    }


}




