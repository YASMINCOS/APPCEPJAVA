package com.yasmin.myapplication.api;

import com.yasmin.myapplication.model.Address;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {


    @GET("ws/{cep}/json/")
    Call<Address> getAddress() ;


}
