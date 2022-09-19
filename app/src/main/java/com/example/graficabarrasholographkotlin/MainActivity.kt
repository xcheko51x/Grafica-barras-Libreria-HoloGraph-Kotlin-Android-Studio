package com.example.graficabarrasholographkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph
import com.example.graficabarrasholographkotlin.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val puntos = ArrayList<Bar>()

        binding.btnAgregar.setOnClickListener {
            graficarBarras(puntos)
        }
    }

    fun graficarBarras(puntos: ArrayList<Bar>) {
        val barra = Bar()
        var color = generarColorHexAleatorio()
        barra.color = Color.parseColor(color)
        barra.name = binding.etConcepto.text.toString()
        barra.value = binding.etCantidad.text.toString().toFloat()

        puntos.add(barra)

        val grafica = findViewById<View>(R.id.graphBar) as BarGraph
        grafica.bars = puntos
    }

    fun generarColorHexAleatorio(): String {
        val letras = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")
        var color = "#"
        for (i in 0..5) {
            color += letras[(Math.random() * 15).roundToInt()]
        }

        return color
    }
}