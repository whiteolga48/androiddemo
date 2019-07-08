package com.mariusapps.pollolokoretrofit;

import com.mariusapps.pollolokoretrofit.model.Camarero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET ("camareros")
    Call<List<Camarero>> getCamareros();

}
