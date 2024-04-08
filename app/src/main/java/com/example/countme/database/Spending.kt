package com.example.countme.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Spendings")
data class Spending(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Int,
)