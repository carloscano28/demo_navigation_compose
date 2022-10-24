package com.example.aplication_jp_compose.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.aplication_jp_compose.MainActivity
import com.example.aplication_jp_compose.databinding.ActivityEjemploBinding

class EjemploActivity : AppCompatActivity() {

    lateinit var binding: ActivityEjemploBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjemploBinding.inflate(layoutInflater)
        setContentView(binding.root).apply {
            setContent {
                Text(text = "Hola Activity Uno")
            }
        }

        //setContentView(R.layout.activity_ejemplo)

        /*with(binding){
            idRegresar.setOnClickListener {
                txtActivityUno.text = "HOLAAA"
                regresar()
                finish() // matar actividad actual
            }
        }*/

    }

    private fun regresar (){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("name", "Valor Activity Uno")
        startActivity(intent)
    }

}