package com.mariusapps.paisesbanderas.retrofit;

import com.mariusapps.paisesbanderas.model.Pais;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRest {



        @GET("all")
        public Call<List<Pais>> getAll();




}
