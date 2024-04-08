package com.example.countme.navigation

sealed class Screens(var route: String) {
    object Home: Screens("Home")
    object Add: Screens("Add")
    object Edit: Screens("Edit/{id}/{name}/{price}")
}