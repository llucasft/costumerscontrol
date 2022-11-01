package com.example.costumers_control.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Manager(
    @PrimaryKey
    val cpf: String,
    val name: String,
    val userName: String,
    val password: String
) : Parcelable