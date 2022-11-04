package com.example.customers_control.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.customers_control.database.AppDatabase
import com.example.customers_control.databinding.ActivityRegisterCostumerFormBinding
import com.example.customers_control.model.Customer
import java.math.BigDecimal

class RegisterCustomerForm : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterCostumerFormBinding

    private val customerDao by lazy {
        val db = AppDatabase.instance(this)
        db.customerDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterCostumerFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCustomerRegisterSave.setOnClickListener {
            val newCustomer = registerNewCustomer()
            //val allFieldsFilled = checkRequiredFields()
            with(binding){
                if (
                    etCustomerRegisterCpf.hint.isBlank() ||
                    etCustomerRegisterName.text.isBlank() ||
                    etCustomerRegisterPhoneNumber.text.isBlank() ||
                    etCustomerRegisterAddress.text.isBlank()) {
                    Toast.makeText(
                        this@RegisterCustomerForm,
                        "Fill all the required data to proceed",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    etCustomerRegisterCpf.hint = "This field is required"
                    etCustomerRegisterName.hint = "This field is required"
                    etCustomerRegisterPhoneNumber.hint = "This field is required"
                    etCustomerRegisterAddress.hint = "This field is required"
                }
                else {
                    customerDao.addNewCustomer(newCustomer)
                }
            }

            Log.i("RegisterCustomer", "Customer ${newCustomer.name} added successfully")
        }
    }

//    private fun checkRequiredFields() {
//        with(binding){
//            if (
//                etCostumerRegisterCpf.hint.isBlank() ||
//                etCostumerRegisterName.text.isBlank() ||
//                etCostumerRegisterPhoneNumber.text.isBlank() ||
//                etCostumerRegisterAddress.text.isBlank()) {
//                Toast.makeText(
//                    this@RegisterCostumerForm,
//                    "Fill all the required data to proceed",
//                    Toast.LENGTH_LONG
//                )
//                    .show()
//                etCostumerRegisterCpf.hint = "This field is required"
//                etCostumerRegisterName.hint = "This field is required"
//                etCostumerRegisterPhoneNumber.hint = "This field is required"
//                etCostumerRegisterAddress.hint = "This field is required"
//            }
//        }
//    }

    private fun registerNewCustomer(): Customer {
        with(binding) {
            val customerName = etCustomerRegisterName.text.toString()
            val customerCpf = etCustomerRegisterCpf.text.toString()
            val customerProfession = etCustomerRegisterProfession.text.toString()
            val customerAmountSpentText = etCustomerRegisterAmountSpent.text.toString()
            val customerAmountSpent = if (customerAmountSpentText.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(customerAmountSpentText)
            }
            val customerEmail = etCustomerRegisterEmail.text.toString()
            val customerPhone = etCustomerRegisterPhoneNumber.text.toString()
            val customerAddress = etCustomerRegisterAddress.text.toString()

            return Customer(
                name = customerName,
                cpf = customerCpf,
                profession = customerProfession,
                amountSpent = customerAmountSpent,
                email = customerEmail,
                phoneNumber = customerPhone,
                address = customerAddress
            )
        }
    }
}