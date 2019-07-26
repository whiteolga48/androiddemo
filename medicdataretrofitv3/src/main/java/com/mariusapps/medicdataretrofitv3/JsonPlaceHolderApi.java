package com.mariusapps.medicdataretrofitv3;

import com.mariusapps.medicdataretrofitv3.Model.Lectura;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {


    // LECTURAS


    @GET("1")
    public Call<List<Lectura>> getLecturas();

    @Headers("Content-type: application/json")
    @POST("1")
    public Call<Lectura> create(@Body Lectura lectura);

}
