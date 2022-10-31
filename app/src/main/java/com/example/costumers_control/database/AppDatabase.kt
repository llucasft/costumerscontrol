package com.example.costumers_control.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.costumers_control.database.dao.ManagerDao
import com.example.costumers_control.model.Manager

@Database(entities = [Manager::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun managerDao(): ManagerDao

    companion object{
        fun instance(context: Context): AppDatabase{
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "customers.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}