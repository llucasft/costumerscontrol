package com.example.costumers_control.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.costumers_control.R
import com.example.costumers_control.databinding.ActivityCustomerDetailBinding

class CustomerDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}