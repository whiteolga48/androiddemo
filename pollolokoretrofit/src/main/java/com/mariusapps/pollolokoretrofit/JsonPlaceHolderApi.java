package com.mariusapps.pollolokoretrofit;

import com.mariusapps.pollolokoretrofit.model.Camarero;
import com.mariusapps.pollolokoretrofit.model.Pedido;
import com.mariusapps.pollolokoretrofit.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET ("camareros")
    Call<List<Camarero>> getCamareros();
    @Headers("Content-type: application/json")
    @POST ("camareros")
    Call<Camarero> create (@Body Camarero camarero); // sobrecarga de métodos  create.



    @GET ("productos")
    Call<List<Producto>> getProductos();
    @Headers("Content-type: application/json")
    @POST ("productos")
    Call<Producto> create (@Body Producto producto); // sobrecarga de métodos  create.


    @GET ("pedidos")

    Call<List<Pedido>> getPedidos();

}
