package com.example.customers_control.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customers_control.databinding.ActivityManagerHomeBinding

class ManagerHomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityManagerHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val welcomeName = intent.getStringExtra("Name")
        binding.tvWelcomeManager.text = "Bem vindo(a), " + welcomeName

        binding.btnAddCustomer.setOnClickListener {
            val intent = Intent(this@ManagerHomeActivity, RegisterCustomerForm::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnQueryCustomer.setOnClickListener {
            val intent = Intent(this@ManagerHomeActivity, CustomerDetailActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}