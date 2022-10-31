package com.example.costumers_control.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Manager(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val cpf: String,
    val userName: String,
    val password: String
) : Parcelable