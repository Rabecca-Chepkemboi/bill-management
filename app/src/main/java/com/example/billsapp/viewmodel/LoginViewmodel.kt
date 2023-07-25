package com.example.billsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.billsapp.model.LoginRequest
import com.example.billsapp.model.LoginResponse
import com.example.billsapp.model.RegisterResponse
import com.example.billsapp.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel :ViewModel(){
    val logLiveData= MutableLiveData<LoginResponse>()
    val errorLiveData= MutableLiveData<String>()
    val loginRepository=LoginRepository()
    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch{
            val response= loginRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                logLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}