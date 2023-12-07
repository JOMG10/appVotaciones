package com.example.elecciones2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import java.security.Principal

class MainActivity : AppCompatActivity() {

    var sumaVotoMorena : Int =0
    var sumavotoMovimiento: Int =0
    var sumaVotoNueva: Int =0
    var sumaVotoPan:Int =0
    var sumaVotoPRD: Int =0
    var sumaVotoPri:Int  =0
    var sumaVotoPt:Int = 0
    var sumaVotoVerde:Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMorena:ImageButton = findViewById(R.id.imbMorena)
        val btnMovimiento:ImageButton = findViewById(R.id.imbMovimiento)
        val btnNueva:ImageButton = findViewById(R.id.imbNuevaAlianza)
        val btnPan:ImageButton = findViewById(R.id.imbPan)
        val btnPrd:ImageButton = findViewById(R.id.imbPrd)
        val btnPri:ImageButton = findViewById(R.id.imbPri)
        val btnPt:ImageButton = findViewById(R.id.imbPt)
        val btnVerde:ImageButton = findViewById(R.id.imbVerde)


        btnMorena.setOnClickListener(){
            cuentaVoto(1)
            Toast.makeText(this,"Morena",Toast.LENGTH_LONG).show()
        }

        btnMovimiento.setOnClickListener(){
            cuentaVoto(2)
            Toast.makeText(this,"MovimientoCiudadano",Toast.LENGTH_LONG).show()
        }

        btnNueva.setOnClickListener(){
            cuentaVoto(3)
            Toast.makeText(this,"NuevaAlianza",Toast.LENGTH_LONG).show()
        }

        btnPan.setOnClickListener(){
            cuentaVoto(4)
            Toast.makeText(this,"PAN",Toast.LENGTH_LONG).show()
        }

        btnPrd.setOnClickListener(){
            cuentaVoto(5)
            Toast.makeText(this,"PRD",Toast.LENGTH_LONG).show()
        }
        btnPri.setOnClickListener(){
            cuentaVoto(6)
            Toast.makeText(this,"PRI",Toast.LENGTH_LONG).show()
        }
        btnPt.setOnClickListener(){
            cuentaVoto(7)
            Toast.makeText(this,"PT",Toast.LENGTH_LONG).show()
        }
        btnVerde.setOnClickListener(){
            cuentaVoto(8)
            Toast.makeText(this,"Partido verde",Toast.LENGTH_LONG).show()
        }
    }

    fun cuentaVoto(numPart : Int){
        when(numPart){
            1-> sumaVotoMorena++
            2-> sumavotoMovimiento++
            3-> sumaVotoNueva++
            4-> sumaVotoPan++
            5-> sumaVotoPRD++
            6-> sumaVotoPri++
            7-> sumaVotoPt++
            8-> sumaVotoVerde++
        }
    }

    fun onClickResultados(view: View) {

        val intent = Intent(this, Resultados::class.java)
        intent.putExtra("morena", sumaVotoMorena)
        intent.putExtra("movimientoCiudadano", sumavotoMovimiento)
        intent.putExtra("nuevaAlianza", sumaVotoNueva)
        intent.putExtra("pan", sumaVotoPan)
        intent.putExtra("prd", sumaVotoPRD)
        intent.putExtra("pri", sumaVotoPri)
        intent.putExtra("pt", sumaVotoPt)
        intent.putExtra("verde", sumaVotoVerde)

        startActivity(intent)
    }

}