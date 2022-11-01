package com.example.costumers_control.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.costumers_control.R
import com.example.costumers_control.databinding.ActivityManagerHomeBinding

class ManagerHomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityManagerHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val welcomeName = intent.getStringExtra("Name")
        binding.tvWelcomeManager.text = "Bem vindo(a), " + welcomeName
    }
}