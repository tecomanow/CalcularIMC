package br.com.matreis.calcularimc.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bmi(
    @PrimaryKey
    val id: Long,
    val weight: Double,
    val height: Double,
    val date: String
)
