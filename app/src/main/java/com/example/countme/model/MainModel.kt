package com.example.countme.model

import android.content.Context
import com.example.countme.database.AppDataBase
import com.example.countme.database.Spending

class MainModel(context: Context) {
    val localDB = AppDataBase.getInstance(context)

    fun getSpendingList(): MutableList<Spending> {
        return localDB.getSpendingDao().getAllData()
    }

    fun addSpending(spending: Spending) {
        localDB.getSpendingDao().insertData(spending)
    }

    fun updateSpending(spending: Spending) {
        localDB.getSpendingDao().updateData(spending)
    }

    fun deleteSpending(spending: Spending) {
        localDB.getSpendingDao().deleteData(spending)
    }
}