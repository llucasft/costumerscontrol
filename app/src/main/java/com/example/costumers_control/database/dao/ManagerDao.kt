package com.example.costumers_control.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.costumers_control.model.Manager

@Dao
interface ManagerDao {

    @Insert
    fun addNewManager(vararg manager: Manager)
}