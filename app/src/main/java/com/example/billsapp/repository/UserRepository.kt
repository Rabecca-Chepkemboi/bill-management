package com.example.billsapp.repository
import com.example.billsapp.api.ApiClient
import com.example.billsapp.api.ApiInterface
import com.example.billsapp.model.RegisterRequest
import com.example.billsapp.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var client=ApiClient.buildClient(ApiInterface::class.java)
    suspend fun registerUser(registerRequest: RegisterRequest):Response<RegisterResponse>{
        return withContext(Dispatchers.IO){
            client.registerUser(registerRequest)
        }
    }
}