package com.example.costumers_control.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.costumers_control.R
import com.example.costumers_control.database.AppDatabase
import com.example.costumers_control.databinding.ActivityRegisterCostumerFormBinding
import com.example.costumers_control.model.Costumer
import java.math.BigDecimal

class RegisterCostumerForm : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterCostumerFormBinding

    private val costumerDao by lazy {
        val db = AppDatabase.instance(this)
        db.costumerDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterCostumerFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCostumerRegisterSave.setOnClickListener {
            val newCostumer = registerNewCostumer()
            //val allFieldsFilled = checkRequiredFields()
            with(binding){
                if (
                    etCostumerRegisterCpf.hint.isBlank() ||
                    etCostumerRegisterName.text.isBlank() ||
                    etCostumerRegisterPhoneNumber.text.isBlank() ||
                    etCostumerRegisterAddress.text.isBlank()) {
                    Toast.makeText(
                        this@RegisterCostumerForm,
                        "Fill all the required data to proceed",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    etCostumerRegisterCpf.hint = "This field is required"
                    etCostumerRegisterName.hint = "This field is required"
                    etCostumerRegisterPhoneNumber.hint = "This field is required"
                    etCostumerRegisterAddress.hint = "This field is required"
                }
                else {
                    costumerDao.addNewCostumer(newCostumer)
                }
            }

            Log.i("RegisterCostumer", "Costumer ${newCostumer.name} added successfully")
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

    private fun registerNewCostumer(): Costumer {
        with(binding) {
            val costumerName = etCostumerRegisterName.text.toString()
            val costumerCpf = etCostumerRegisterCpf.text.toString()
            val costumerProfession = etCostumerRegisterProfession.text.toString()
            val costumerAmountSpentText = etCostumerRegisterAmountSpent.text.toString()
            val costumerAmountSpent = if (costumerAmountSpentText.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(costumerAmountSpentText)
            }
            val costumerEmail = etCostumerRegisterEmail.text.toString()
            val costumerPhone = etCostumerRegisterPhoneNumber.text.toString()
            val costumerAddress = etCostumerRegisterAddress.text.toString()

            return Costumer(
                name = costumerName,
                cpf = costumerCpf,
                profession = costumerProfession,
                amountSpent = costumerAmountSpent,
                email = costumerEmail,
                phoneNumber = costumerPhone,
                address = costumerAddress
            )
        }
    }
}