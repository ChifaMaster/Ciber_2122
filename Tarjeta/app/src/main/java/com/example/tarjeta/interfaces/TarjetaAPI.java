package com.example.tarjeta.interfaces;

import com.example.tarjeta.models.Tarjeta;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TarjetaAPI {
    @GET("infocards2/{user1}")
    public Call<Tarjeta> find(@Path("user1") String user);
}
