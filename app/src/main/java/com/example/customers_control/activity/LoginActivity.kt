package com.example.customers_control.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customers_control.database.AppDatabase
import com.example.customers_control.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding:ActivityLoginBinding

    private val managerDao by lazy {
        val db = AppDatabase.instance(this)
        db.managerDao()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnLogin.setOnClickListener {
                val cpf = etRegisterUserLoginCpf.text.toString()
                val password = etRegisterUserPassword.text.toString()
                if (cpf.equals("") or cpf.isBlank() or password.equals("") or password.isBlank()){
                    Toast.makeText(this@LoginActivity, "Need to fill information to login", Toast.LENGTH_LONG).show()
                } else {
                    val managerLogin = managerDao.managerAuthentication(cpf, password)
                    if (managerLogin?.cpf !=null){
                        if (managerLogin.cpf == cpf && managerLogin.password == password){
                            val intent = Intent(this@LoginActivity, ManagerHomeActivity::class.java)
                            intent.putExtra("Name", managerLogin.name)
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        Toast.makeText(this@LoginActivity, "Authentication failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterFormActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}