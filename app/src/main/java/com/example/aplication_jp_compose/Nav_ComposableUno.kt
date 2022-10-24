package com.example.aplication_jp_compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NavCompUno(
    navController: NavController,
    textRecived: String) {

    Surface(color = Color.Blue, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TopAppBar (
                title = { Text("PAntalla JPComp Uno")},
                backgroundColor = Color.Cyan,
                contentColor = Color.Black,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "")
                    }
                }
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Text(text = textRecived, style = MaterialTheme.typography.h6, color = Color.White )
            Spacer(modifier = Modifier.padding(32.dp))
            TextoPantCompUno(name = "PAntalla JPComp Uno")
            Spacer(modifier = Modifier.padding(4.dp))
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .height(60.dp)
                    .width(300.dp)
                    .clip(CircleShape)
            ) {
                Text(text = "Return Home", style = MaterialTheme.typography.h6)
            }
        }
    }
}

@Composable
fun TextoPantCompUno(name: String) {
    Text(text = "Hello $name!", style = MaterialTheme.typography.h6, color = Color.White )
}