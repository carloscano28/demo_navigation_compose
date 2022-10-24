package com.example.aplication_jp_compose

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Home(enviarParametros: (String) -> Unit ) {
//fun Home(navController: NavController) {

   Surface(color = Color.Blue, modifier = Modifier.fillMaxSize()) {

       var textValue by remember { mutableStateOf("") }

       Column(
           modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       )
       {

           TextField(
               value = textValue,
               onValueChange = {textValue=it},
               label = {Text("Introducir texto")},
           )
           Spacer(modifier = Modifier.padding(4.dp))
           Button(
               colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
               //onClick = { navController.navigate(Screen.PNAVCOMPUNO.ruta){
               onClick = { enviarParametros(textValue)},
               modifier = Modifier
                   .height(60.dp)
                   .width(300.dp)
                   .clip(CircleShape)
           ) {
               Text(text = "PAntalla JPComp Uno")
           }
           Spacer(modifier = Modifier.padding(4.dp))
           Button(
               colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
               onClick = {  },
               modifier = Modifier
                   .height(60.dp)
                   .width(300.dp)
                   .clip(CircleShape)
           ) {
               Text(text = "IR a ... Action ")
           }
       }
    }


}

@Composable
fun goToActivityUno (context : Context){
    //val intent = Intent(context, ActivityUno::class.java)
    //ContextCompat.startActivity(intent)
}