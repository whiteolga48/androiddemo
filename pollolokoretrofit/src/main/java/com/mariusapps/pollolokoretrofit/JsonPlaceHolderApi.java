package com.mariusapps.pollolokoretrofit;

import com.mariusapps.pollolokoretrofit.model.Camarero;
import com.mariusapps.pollolokoretrofit.model.Pedido;
import com.mariusapps.pollolokoretrofit.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET ("camareros")
    Call<List<Camarero>> getCamareros();

    @GET ("productos")
    Call<List<Producto>> getProductos();

    @GET ("pedidos")

    Call<List<Pedido>> getPedidos();

}
