package com.example.customers_control.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.customers_control.model.Customer

@Dao
interface CustomerDao {
    @Insert
    fun addNewCustomer(vararg customer: Customer)

    @Query("SELECT * FROM Customer WHERE cpf = :cpf")
    fun queryCustomer(cpf: String): Customer?

}