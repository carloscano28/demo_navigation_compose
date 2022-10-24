package com.example.aplication_jp_compose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aplication_jp_compose.ui.theme.Aplication_JP_ComposeTheme
import kotlinx.coroutines.delay

sealed class Screen (val ruta : String){

    object HOME: Screen("Home")
    object PNAVCOMPUNO: Screen("NavCompUno/?newText={newText}"){
        fun createRoute (newText: String) = "NavCompUno/?newText=$newText"
    }

}

//class MainActivity : AppCompatActivity() {
class MainActivity : ComponentActivity() {

    //lateinit var binding:
     //var nombreExtra : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        //intent.extras?.let { bundle->
          //  nombreExtra= bundle.getString("name")
        //}

        setContent {
            Aplication_JP_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navegacion()
                    //OtroSwipe()  // swipe refresh
                    //GoToActivityUno(this)
                }
            }
        }


    }




}

/*@Composable
    fun OtroSwipe() {
        val context = LocalContext.current
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "title")},
                )
            },
            //modifier = Modifier.fillMaxSize(),
            content =  {
                SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing= false),
                    onRefresh = {
                        //GSFUTools.Logs.i("MEnsaje reresh")
                    },
                    indicator = {state, refreshTrigger ->
                        SwipeRefreshIndicator(
                            state = state,
                            refreshTriggerDistance = refreshTrigger,
                            scale = true,
                            backgroundColor = Color.Gray
                        )
                    }
                ){
                    SimpleComposable()
                }
            }
        )
    }*/

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination =  Screen.HOME.ruta){
        // *** Rutas de las pantallas ***
        // Home
        composable(Screen.HOME.ruta){
            Home(
                enviarParametros = { newText ->
                    navController.navigate(Screen.PNAVCOMPUNO.createRoute(newText)){
                        popUpTo(Screen.HOME.ruta)
                    }
                }
            )
            //Home(navController = navController)
        }
        composable(
            Screen.PNAVCOMPUNO.ruta,
            arguments = listOf(navArgument("newText"){defaultValue = "default"})
        ){ navBackStackEntry->
            val newText = navBackStackEntry.arguments?.getString("newText")
            requireNotNull(newText)
            NavCompUno(navController = navController, newText)
        }
    }
}

@Composable
private fun GoToActivityUno(context: Context ) {
    //val intent = Intent(this, ActivityUno::class.java) // no encuentra referencia a ActivityUno
    //startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Aplication_JP_ComposeTheme {
        Navegacion()
    }
}



