package com.mariusapps.pollolokoretrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductosLista extends AppCompatActivity {

    private TextView textViewResult ;

    private JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_lista);

        textViewResult=findViewById(R.id.IdTextViewProducto);

        // Gson se encarga del mapping entre Java <----> JSON
        // Como las fechas vienen en milisegundos hemos de construir de forma manual el adaptador
        // Necesitamos un adaptador para serializar y otro para deserializar

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                long milisegundos = json.getAsJsonPrimitive().getAsLong();
                return new Date(milisegundos);
            }
        });

        gsonBuilder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {

            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                long milisegundos = src.getTime();
                return new JsonPrimitive(milisegundos);
            }
        });

        Gson gson = gsonBuilder.create(); // En Camarero no necesitamos de un gson...



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson)) // NUEVO!
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getProductos();



    }

    private void getProductos(){
        Call<List<Producto>> call = jsonPlaceHolderApi.getProductos();
        call.enqueue(new Callback<List<Producto>>()     {



            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                if (!response.isSuccessful()) {

                    textViewResult.setText("Code: " + response.code());
                    Log.d("**", "onResponse: "+ response.code());

                    return;
                }


                List<Producto> productos = response.body();

                for (Producto producto:productos){
                    String content = "" ;

                    content += "Código : " + producto.getCodigo() + "\n";
                    content += "nombre : " + producto.getNombre() + "\n";
                    content += "precio : " + producto.getPrecio() + "\n";
                    content += "descripción : " + producto.getDescripcion() + "\n";
                    content += "fecha : " + producto.getFechaAlta() + "\n";
                    content += "categoría : " + producto.getCategoria() + "\n\n";

                    textViewResult.append(content);
                    Log.d("***", content);
                    textViewResult.setMovementMethod(new ScrollingMovementMethod());
                }

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }

}



