package com.example.billsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billsapp.R
import com.example.billsapp.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    lateinit var binding:ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}