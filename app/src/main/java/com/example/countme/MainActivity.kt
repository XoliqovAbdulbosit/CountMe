package com.example.countme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.countme.navigation.SetNavGraph
import com.example.countme.ui.theme.CountMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountMeTheme {
                val navController = rememberNavController()
                SetNavGraph(navController = navController)
            }
        }
    }
}