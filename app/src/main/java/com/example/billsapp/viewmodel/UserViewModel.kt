package com.example.billsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.billsapp.model.RegisterRequest
import com.example.billsapp.model.RegisterResponse
import androidx.lifecycle.viewModelScope
import com.example.billsapp.model.LoginRequest
import com.example.billsapp.model.LoginResponse
import com.example.billsapp.repository.LoginRepository
import com.example.billsapp.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val regLiveData = MutableLiveData<RegisterResponse>()
    val errorLiveData = MutableLiveData<String>()
    val userRepository = UserRepository()

    fun registerUser(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequest)
            regLiveData.postValue(response.body())
            if (response.isSuccessful) {
                regLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}