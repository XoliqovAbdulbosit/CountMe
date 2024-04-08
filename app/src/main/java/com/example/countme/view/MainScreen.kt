package com.example.countme.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.countme.navigation.Screens
import com.example.countme.ui.theme.Main
import com.example.countme.ui.theme.Secondary
import com.example.countme.viewmodel.MainViewModel

@Composable
fun MainScreen(model: MainViewModel, navController: NavController) {
    var spendings by remember { mutableStateOf(model.getSpendings()) }
    var detailedInfo by remember { mutableStateOf(model.getDetailedInfo()) }
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate(Screens.Add.route) },
        ) {
            Icon(Icons.Filled.Edit, "Floating action button.")
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "CountMe", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Main)
            Column(modifier = Modifier.padding(vertical = 20.dp)) {
                Text("Total", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Main)
                Text(detailedInfo.total.toString() + "$", fontSize = 20.sp, color = Main)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Income", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Main)
                    Text(detailedInfo.income.toString() + "$", fontSize = 20.sp, color = Main)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Outcome", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Main)
                    Text(detailedInfo.outcome.toString() + "$", fontSize = 20.sp, color = Main)
                }
            }
            LazyColumn {
                items(spendings) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(vertical = 3.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = it.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Main
                        )
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = it.price.toString() + "$",
                            fontSize = 18.sp,
                            color = Secondary
                        )
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = { navController.navigate("Edit/${it.id}/${it.name}/${it.price}") }) {
                                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                            }
                            IconButton(onClick = {
                                model.deleteSpending(it)
                                spendings = model.getSpendings()
                                detailedInfo = model.getDetailedInfo()
                            }) {
                                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                            }
                        }
                    }
                }
            }
        }
    }
}
