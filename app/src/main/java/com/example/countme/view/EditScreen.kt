package com.example.countme.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.countme.database.Spending
import com.example.countme.navigation.Screens
import com.example.countme.ui.theme.Main
import com.example.countme.ui.theme.Secondary
import com.example.countme.viewmodel.MainViewModel

@Composable
fun EditScreen(
    id: Int, name: String, price: Int, model: MainViewModel, navController: NavController
) {
    var uname by remember { mutableStateOf(name) }
    var uprice by remember { mutableStateOf(price.toString()) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "CountMe", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Main)
        OutlinedTextField(
            value = uname,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 7.dp),
            onValueChange = { uname = it },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(text = "Name", fontSize = 14.sp) },
            textStyle = TextStyle(fontSize = 16.sp)
        )
        OutlinedTextField(
            value = uprice,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 7.dp),
            onValueChange = { uprice = it },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(text = "Price", fontSize = 14.sp) },
            textStyle = TextStyle(fontSize = 16.sp)
        )
        FloatingActionButton(
            containerColor = Secondary,
            modifier = Modifier.padding(vertical = 10.dp),
            onClick = {
                model.updateSpending(Spending(id = id, name = uname, price = uprice.toInt()))
                navController.navigate(Screens.Home.route)
            }) {
            Text(
                text = "Register",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 7.dp)
            )
        }
    }
}