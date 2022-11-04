package com.example.customers_control.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customers_control.database.AppDatabase
import com.example.customers_control.databinding.ActivityCustomerDetailBinding
import com.example.customers_control.model.Customer

class CustomerDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerDetailBinding

    private val customerDao by lazy {
        val db = AppDatabase.instance(this)
        db.customerDao()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnQueryCustomer.setOnClickListener {
            with(binding){
                val cpf = binding.etQueryCostumerCpf.text.toString()
                val customer = customerDao.queryCustomer(cpf)
                if (customer != null){
                    tvCostumerInfoName.text = customer.name
                    tvCostumerInfoCpf.text = customer.cpf
                    tvCostumerInfoProfession.text = customer.profession
                    //tvCostumerInfoAmountSpent.text = customer.amountSpent
                    tvCostumerInfoEmail.text = customer.email
                    tvCostumerInfoPhone.text = customer.phoneNumber
                    tvCostumerInfoAddress.text = customer.address
                } else {
                    Toast.makeText(
                        this@CustomerDetailActivity,
                        "Customer not found",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}