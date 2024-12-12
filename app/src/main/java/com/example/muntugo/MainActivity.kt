package com.example.muntugo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.muntugo.databinding.ActivityMainBinding
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val reservationButton: Button = findViewById(R.id.reservationButton)
        val gestionButton: Button = findViewById(R.id.gestionButton)

        reservationButton.setOnClickListener {
            val intent = Intent(this, VoyageActivity::class.java)
            startActivity(intent)
        }

        gestionButton.setOnClickListener {
            val intent = Intent(this, TransportActivity::class.java)
            startActivity(intent)
        }

        // Kotlin
        val spinnerRoleGestion: Spinner = findViewById(R.id.spinnerRoleGestion)
        val adapter = ArrayAdapter.createFromResource(this, R.array.roles, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerRoleGestion.adapter = adapter
    }

}
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin: Button = findViewById(R.id.buttonLogin)
        val textViewRegister: TextView = findViewById(R.id.textViewRegister)

        // Gestion de l'événement de clic sur le bouton de connexion
        buttonLogin.setOnClickListener {
            // Rediriger vers l'interface de réservation ou de transport
            // Remplacez "ReservationActivity" par l'activité appropriée
            val intent = Intent(this, VoyageActivity::class.java)
            startActivity(intent)
        }

        // Gestion de l'événement de clic sur le texte d'inscription
        textViewRegister.setOnClickListener {
            // Rediriger vers l'interface d'inscription
            // Remplacez "RegisterActivity" par l'activité d'inscription appropriée
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
