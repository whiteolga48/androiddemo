package com.mariusapps.paisesbanderas.retrofit;

import com.mariusapps.paisesbanderas.model.Pais;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiRest {


        @GET("all")
        public Call<List<Pais>> getAll();


        @GET("alpha/{cod}")
        Call<Pais> getByCode(@Path("cod") String codigo);
}



