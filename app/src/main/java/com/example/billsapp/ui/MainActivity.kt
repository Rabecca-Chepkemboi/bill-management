package com.example.billsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billsapp.R
import com.example.billsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }


//        setContentView(binding.root)
//        binding.btnSignUp.setOnClickListener {
//        setContentView(binding.root)
//        binding.btnSignUp.setOnClickListener {
//           validateRegistration()
//        }
    }

    fun validateRegistration() {
        val name1 = binding.etname1.text.toString()
        val name2=binding.etname2 .text.toString()
        val email =binding.etemail .text.toString()
        val password=binding.etpassword.text.toString()
        val confirm=binding.etconfirmpassword.text.toString()
        var error = false

        if (name1.isBlank()) {
            binding.tilname1.error = "first name required"
            error=true
        }

        if (name2.isBlank()){
        binding.tilname2.error = "second name required"
        error = true
        }

        if (email.isBlank()){
            binding.tilemail.error = "email required"
            error = true
        }

        if (password.isBlank()){
            binding.tilpassword.error = "password required"
            error = true
        }

        if (confirm.isBlank()){
            binding.tilconfirmpassword.error = "password must me confirmed"
            error = true
        }

        if (!error){
            val intent = Intent(this, LogIn::class.java)
          startActivity(intent)
        }
    }
}