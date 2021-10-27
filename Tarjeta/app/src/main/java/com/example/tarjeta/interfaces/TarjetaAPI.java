package com.example.tarjeta.interfaces;

import com.example.tarjeta.models.Tarjeta;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface TarjetaAPI {
    @GET("infocards2/user1/")
    Call<String> getStringScalar(@Body String body);
}
