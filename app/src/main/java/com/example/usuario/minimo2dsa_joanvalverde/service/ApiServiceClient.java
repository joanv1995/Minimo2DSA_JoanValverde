package com.example.usuario.minimo2dsa_joanvalverde.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by usuario on 18/12/2017.
 */

public interface ApiServiceClient {

    @GET("login/{nomPlayer}/{password}")
    Call<Boolean> loginUser(@Path("nomPlayer") String nomPlayer, @Path("password") String password);

}
