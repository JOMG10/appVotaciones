package com.example.elecciones2023

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Resultados : AppCompatActivity() {

    private lateinit var tableLayout: TableLayout

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        val votosMorena = intent.extras?.getInt("morena", 0) ?: 0
        val votosMovimiento = intent.extras?.getInt("movimientoCiudadano", 0) ?: 0
        val votosNuevaAlianza = intent.extras?.getInt("nuevaAlianza", 0) ?: 0
        val votosPan = intent.extras?.getInt("pan", 0) ?: 0
        val votosPrd = intent.extras?.getInt("prd", 0) ?: 0
        val votosPri = intent.extras?.getInt("pri", 0) ?: 0
        val votosPt = intent.extras?.getInt("pt", 0) ?: 0
        val votosVerde = intent.extras?.getInt("verde", 0) ?: 0

        val totalVotes = votosMorena + votosPan + votosPrd + votosPri + votosPt + votosMovimiento + votosNuevaAlianza + votosVerde
        val porcebtajeMorena = votosMorena * 100 / totalVotes
        val porcentajeMovimiento = votosMovimiento * 100 / totalVotes
        val porcentajeNueva = votosNuevaAlianza * 100 / totalVotes
        val porcentajePan = votosPan * 100 / totalVotes
        val porentajePrd = votosPrd * 100 / totalVotes
        val porcentajePri = votosPri * 100 / totalVotes
        val porcentajePt = votosPt * 100 / totalVotes
        val porcentajeVerde = votosVerde * 100 / totalVotes


            val listaInformacion = listOf(
                Triple(R.drawable.logomorena, "Morena", Pair(votosMorena ?: 0, porcebtajeMorena)),
                Triple(R.drawable.logomovciudadano,"movimiento ciudadano",Pair(votosMovimiento ?: 0, porcentajeMovimiento)),
                Triple(R.drawable.logonuevaalianza,"nueva alianza",Pair(votosNuevaAlianza ?: 0, porcentajeNueva)),
                Triple(R.drawable.logopan, "Pan", Pair(votosPan ?: 0, porcentajePan)),
                Triple(R.drawable.logoprd, "Prd", Pair(votosPrd ?: 0, porentajePrd)),
                Triple(R.drawable.logopri, "pri", Pair(votosPri ?: 0, porcentajePri)),
                Triple(R.drawable.logopt, "pt", Pair(votosPt ?: 0, porcentajePt)),
                Triple(R.drawable.logoverde, "verde", Pair(votosVerde ?: 0, porcentajeVerde))
            )

            tableLayout = findViewById(R.id.tableLayout)
            for (informacion in listaInformacion) {
                agregarFilaConInformacion(informacion)
            }
        }


    private fun agregarFilaConInformacion(informacion: Triple<Int, String, Pair<Int, Int>>) {
        val tableRow = TableRow(this)

        val imageView = ImageView(this)
        imageView.setImageResource(informacion.first)
        val layoutParamsImagen = TableRow.LayoutParams(150, 150)
        layoutParamsImagen.setMargins(150, 10, 150, 10)
        imageView.layoutParams = layoutParamsImagen
        tableRow.addView(imageView)

        val totalVotosTextView = TextView(this)
        totalVotosTextView.text = informacion.third.first.toString()
        totalVotosTextView.textSize = 25f // Cambia el valor según sea necesario
        val layoutParamsTotalVotos = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        layoutParamsTotalVotos.setMargins(50, 15, 0, 10)
        totalVotosTextView.layoutParams = layoutParamsTotalVotos
        tableRow.addView(totalVotosTextView)

        val porcentajeTextView = TextView(this)
        porcentajeTextView.text = informacion.third.second.toString()
        porcentajeTextView.textSize = 25f // Cambia el valor según sea necesario
        val layoutParamsPorcentaje = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        //layoutParamsPorcentaje.setMargins(30, 10, 0, 10)
        porcentajeTextView.layoutParams = layoutParamsPorcentaje
        tableRow.addView(porcentajeTextView)

        // Agregar la fila a la tabla
        tableLayout.addView(tableRow)
    }

    fun onClickRegresar(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}

