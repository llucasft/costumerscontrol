package com.example.costumers_control.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.costumers_control.model.Costumer

@Dao
interface CostumerDao {
    @Insert
    fun addNewCostumer(vararg costumer: Costumer)
}