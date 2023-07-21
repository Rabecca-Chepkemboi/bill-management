package com.example.billsapp.api

import com.example.billsapp.model.LoginRequest
import com.example.billsapp.model.LoginResponse
import com.example.billsapp.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun registerUser(@Body registerRequest: LoginRequest):Response<RegisterResponse>

    @POST("users/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}