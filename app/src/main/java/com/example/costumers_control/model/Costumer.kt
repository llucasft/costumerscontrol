package com.example.costumers_control.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Entity
@Parcelize
data class Costumer(
        @PrimaryKey
        var cpf: String,
        var name: String,
        var profession: String? = null,
        var amountSpent: BigDecimal? = null,
        var email: String? = null,
        var phoneNumber: String?,
        var address: String
) : Parcelable