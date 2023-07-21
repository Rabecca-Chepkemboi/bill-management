package com.example.billsapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.billsapp.R
import com.example.billsapp.databinding.ActivityLoginBinding
import com.example.billsapp.viewmodel.LoginViewModel

class LogIn : AppCompatActivity() {
    val loginViewModel: LoginViewModel by viewModels()
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.buttonLogIn.setOnClickListener {
            validateLogIn()
        }

        loginViewModel.logLiveData.observe(this, Observer { logResponse ->
            Toast.makeText(this,logResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this,HomePage::class.java))
        })
        loginViewModel.logLiveData.observe(this, Observer { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })
        binding.buttonLogIn.setOnClickListener {
            startActivity(Intent(this,HomePage::class.java))
        }

    }
    fun validateLogIn(){
        val name = binding.etUsername.text.toString()
        val email = binding.etemail.text.toString()
        val password = binding.etpassword.text.toString()
        val phone = binding.etphonenumber.text.toString()
        var error = false
        if (name.isBlank()){
            binding.tilUsername.error = "username required"
            error = true
        }

        if (email.isBlank()){
            binding.tilEmail.error = "emailrequired"
            error = true
        }

        if (password.isBlank()){
            binding.tilpassword.error = "password required"
            error = true
        }

        if (phone.isBlank()){
            binding.tilphonenumber.error = "phone number required"
            error = true
        }
    }
}

