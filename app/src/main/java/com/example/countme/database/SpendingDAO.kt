package com.example.countme.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SpendingDAO {
    @Insert
    fun insertData(spending: Spending)

    @Delete
    fun deleteData(spending: Spending)

    @Update
    fun updateData(spending: Spending)

    @Query("SELECT * FROM Spendings")
    fun getAllData(): MutableList<Spending>
}