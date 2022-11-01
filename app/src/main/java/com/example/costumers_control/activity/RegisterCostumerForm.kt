package com.example.costumers_control.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.costumers_control.R
import com.example.costumers_control.databinding.ActivityRegisterCostumerFormBinding

class RegisterCostumerForm : AppCompatActivity() {

    lateinit var binding: ActivityRegisterCostumerFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterCostumerFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}