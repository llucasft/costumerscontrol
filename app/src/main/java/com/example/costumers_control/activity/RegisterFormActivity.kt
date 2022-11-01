package com.example.costumers_control.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.costumers_control.database.AppDatabase
import com.example.costumers_control.database.dao.ManagerDao
import com.example.costumers_control.databinding.ActivityRegisterFormBinding
import com.example.costumers_control.model.Manager

class RegisterFormActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterFormBinding

    private val managerDao by lazy {
        val db = AppDatabase.instance(this)
        db.managerDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnRegister.setOnClickListener {

            try {
                val newManager = registerNewManager()
                managerDao.addNewManager(newManager)
                val intent = Intent(this, ManagerHomeActivity::class.java)
                intent.putExtra("Name", newManager.name)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Erro CPF já cadastrado",
                    Toast.LENGTH_LONG)
                    .show()
                Log.i("btnRegister", e.message.toString())
            }
        }

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun registerNewManager(): Manager {
        with(binding) {
            val managerName = etRegisterUserName.text.toString()
            val managerCpf = etRegisterCPF.text.toString()
            val managerLogin = etRegisterUserLogin.text.toString()
            val managerPassword = etRegisterUserPassword.text.toString()

            return Manager(
                name = managerName,
                cpf = managerCpf,
                userName = managerLogin,
                password = managerPassword
            )
        }
    }
}