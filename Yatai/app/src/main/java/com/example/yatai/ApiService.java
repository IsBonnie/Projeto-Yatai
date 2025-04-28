package com.example.yatai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/apis/login.php")
    Call<List<LoginResponse>> login(
            @Query("usuario") String usuario,
            @Query("senha") String senha
    );
}
