package com.example.countme.viewmodel

import android.content.Context
import com.example.countme.database.Spending
import com.example.countme.model.MainModel

data class DetailedInfo(
    var total: Int,
    var income: Int,
    val outcome: Int,
)

class MainViewModel(context: Context) {
    private val model = MainModel(context)

    fun addSpending(spending: Spending) {
        model.addSpending(spending)
    }

    fun deleteSpending(spending: Spending) {
        return model.deleteSpending(spending)
    }

    fun updateSpending(spending: Spending) {
        return model.updateSpending(spending)
    }

    fun getSpendings(): List<Spending> {
        return model.getSpendingList()
    }

    fun getDetailedInfo(): DetailedInfo {
        var total = 0
        var income = 0
        var outcome = 0
        for (item in getSpendings()) {
            if (item.price > 0) income += item.price
            else outcome += item.price
            total += item.price
        }
        return DetailedInfo(total, income, outcome)
    }
}