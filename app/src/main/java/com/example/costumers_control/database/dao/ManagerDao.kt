package com.example.costumers_control.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.costumers_control.model.Manager

@Dao
interface ManagerDao {

    @Insert
    fun addNewManager(vararg manager: Manager)

    @Query("SELECT * FROM Manager WHERE cpf = :cpf AND password = :password")
    fun managerAuthentication(cpf: String, password: String): Manager?
}