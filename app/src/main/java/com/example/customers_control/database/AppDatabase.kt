package com.example.customers_control.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.customers_control.database.dao.CustomerDao
import com.example.customers_control.database.dao.ManagerDao
import com.example.customers_control.model.Customer
import com.example.customers_control.model.Manager

@Database(entities = [Manager::class, Customer::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun managerDao(): ManagerDao
    abstract fun customerDao(): CustomerDao

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