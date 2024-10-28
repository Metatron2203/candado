package com.example.candado

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pantalla2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        class Pantalla2 : AppCompatActivity() {

            private lateinit var mediaPlayer: MediaPlayer
            private var isLocked = true

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_pantalla2)

                val btnDesbloquear = findViewById<Button>(R.id.btnDesbloquear)
                val btnBloquear = findViewById<Button>(R.id.btnBloquear)
                val btnAlarma = findViewById<Button>(R.id.btnAlarma)
                val btnCrud = findViewById<Button>(R.id.btn_crud)

                //desbloquear
                btnDesbloquear.setOnClickListener {
                    if (isLocked) {
                        isLocked = false
                        Toast.makeText(this, "Candado desbloqueado", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "El candado ya está desbloqueado", Toast.LENGTH_SHORT).show()
                    }
                }

                //bloquear
                btnBloquear.setOnClickListener {
                    if (!isLocked) {
                        isLocked = true
                        Toast.makeText(this, "Candado bloqueado", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "El candado ya está bloqueado", Toast.LENGTH_SHORT).show()
                    }
                }

                //alarma
                btnAlarma.setOnClickListener {
                    mediaPlayer = MediaPlayer.create(this, R.raw.alarma)
                    mediaPlayer.start()
                }

                //abrir la pantalla de historial
                btnCrud.setOnClickListener {
                    val intent = Intent(this, pantalla3::class.java)
                    startActivity(intent)
                }
            }

            override fun onDestroy() {
                super.onDestroy()
                if (::mediaPlayer.isInitialized) {
                    mediaPlayer.release() // Liberar el recurso del media player al cerrar la actividad
                }
            }
        }
        //boton para iniciar pantalla 3
        val Button_crud = findViewById<Button>(R.id.btn_crud)

        val intent = Intent(this, pantalla3::class.java)
        startActivity(intent)
    }
}