package com.example.gobuhat;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface
{
    @GET("register.php")
    Call<User> performRegitration(
            @Query("name") String Name,
            @Query("user_name") String UserName,
            @Query("user_surname") String UserSurname,
            @Query("user_email") String UserEmail,
            @Query("user_password") String UserPassword,
            @Query("credits") int Credits);

    @GET("login.php")
    Call<User> performUserLogin(@Query("user_name") String UserName, @Query("user_password") String UserPassword);
}
