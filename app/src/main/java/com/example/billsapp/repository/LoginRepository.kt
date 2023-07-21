package com.example.billsapp.repository

import com.example.billsapp.api.ApiClient
import com.example.billsapp.api.ApiInterface
import com.example.billsapp.model.LoginRequest
import com.example.billsapp.model.LoginResponse
import com.example.billsapp.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {
    var client= ApiClient.buildClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
        return withContext(Dispatchers.IO){
            client.loginUser(loginRequest)
        }
    }
}
