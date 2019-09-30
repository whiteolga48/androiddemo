package com.mariusapps.paisesbanderas;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mariusapps.paisesbanderas.model.Pais;
import com.mariusapps.paisesbanderas.retrofit.ApiRest;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetallePais extends AppCompatActivity {

   // private List<Pais> paises;

    private ImageView imageViewBandera;
    private TextView nombrePais;
    private TextView idiomaPais;
    private TextView poblacionPais;
    private TextView capitalPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);

        nombrePais = findViewById(R.id.idNombrepais);
        idiomaPais = findViewById(R.id.idIdiomaDet);
        poblacionPais = findViewById(R.id.IdPoblacionDet);
        capitalPais = findViewById(R.id.idCapitalDet);
        imageViewBandera = findViewById(R.id.idBanderaDet);

        Bundle extras = getIntent().getExtras();
        extras.getString("codigo");
        Log.d("***", "Detalle País " + extras.toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiRest apiRest = retrofit.create(ApiRest.class);

        // STOP


        //String codigo = extras.toString();

        String codigo = extras.getString("codigo");

        Log.d("***", "codigo:  " + extras.toString());
        Call<Pais> call = apiRest.getByCode(codigo);
        call.enqueue(new Callback<Pais>(){


            @Override
            public void onResponse(Call<Pais> call, Response<Pais> response) {

                Log.d("***",response.toString());

                if (!response.isSuccessful()){
                    Log.d("**", "onResponse: "+ response.code());
                    return;
                }

                // AQUI HABEMUS DATOS

//                List<Pais> pais = (List<Pais>) response.body();

                    Pais pais = response.body();

                nombrePais.setText(pais.getName());
                capitalPais.setText(pais.getCapital());
                idiomaPais.setText(pais.getNativeName());



               DecimalFormat myFormatter = new DecimalFormat("###,###,###.##",
                       DecimalFormatSymbols.getInstance(Locale.GERMANY));

               poblacionPais.setText( myFormatter.format(pais.getPopulation())+ " Hab.");
//
//                poblacionPais.setText(pais.getPopulation());



                 String imageURL = "https://www.countryflags.io/" + pais.getAlpha2Code()
                        +   "/flat/64.png";

                Picasso
                        .get()

                        .load(imageURL)

                        .resize(700, 600) // resizes the image to these dimensions (in pixel)
                       .centerCrop()
                        .into(imageViewBandera);






                Log.d("***", "nombre: ");




                Log.d("***","response body: " + response.body().toString());




            }

            @Override
            public void onFailure(Call<Pais> call, Throwable t) {


            }

        });



    }
}
