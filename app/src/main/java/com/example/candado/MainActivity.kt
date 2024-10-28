package com.example.candado

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Obtener los elementos de la interfaz
        val editTextUsuario = findViewById<EditText>(R.id.Et_person)
        val editTextPassword = findViewById<EditText>(R.id.Et_pass)
        val loginButton = findViewById<Button>(R.id.button)

        loginButton.setOnClickListener {
            val usuario = editTextUsuario.text.toString().trim()
            val contraseña = editTextPassword.text.toString().trim()

            // Validacion para verificar si los campos están vacios
            if (usuario.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese su usuario", Toast.LENGTH_SHORT).show()
            } else if (contraseña.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese su contraseña", Toast.LENGTH_SHORT).show()
            } else {
                // Validacion de usuario y contraseña correctos
                if (usuario == "admin" && contraseña == "1234") {
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                    // ir    a pantalla2
                    val intent = Intent(this, pantalla2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
} 