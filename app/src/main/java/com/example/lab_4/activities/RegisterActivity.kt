package com.example.lab_4.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.lab_4.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private var guestRegistered = 0
    private var currentGuest = 0
    private var guestCount = 1;

    // Contains all the views



    data class Guest(val name: String, val phone: String, val email: String, val registered: Boolean )

    private val allGuest = listOf(
        Guest("Andrei Portales", "45674638", "andreiportales@uvg.edu.gt", false),
        Guest("Marco Perez", "31251678", "marcoperez@uvg.edu.gt", false),
        Guest("Hansel Lopez", "48252369", "hansellopez@uvg.edu.gt", false),
        Guest("Christian Perez", "87648378", "christianperez@uvg.edu.gt", false),
        Guest("Javier Hurtarte", "58302598", "javierhurtarte@uvg.edu.gt", false),
        Guest("Oscar de Leon", "56306847", "oscardeleon@uvg.edu.gt", false),
        Guest("Ana Castillo", "45511189", "anacastillo@uvg.edu.gt", false),
        Guest("Edman Cota", "42595836", "edmancota@uvg.edu.gt", false)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setSupportActionBar(findViewById(R.id.register_toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        text_total.text = guestCount.toString() + " /8"

        showCurrentGuest(currentGuest)

        button_yes.setOnClickListener {
            onYesGuestClicked()
        }

        button_no.setOnClickListener {
            onNoGuestClicked()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.nav_no -> {
            Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.nav_yes -> {
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }


    @SuppressLint("SetTextI18n")
    private fun onYesGuestClicked() {

        guestRegistered++
        currentGuest++
        guestCount++

        if(guestCount == 9) {
            createAcitivity()
        } else {
            showCurrentGuest(currentGuest)
            text_total.text = guestCount.toString() + " /8"
        }

    }

    private fun onNoGuestClicked() {

        currentGuest++
        guestCount++

        if(guestCount == 9) {
            createAcitivity()
        } else {
            showCurrentGuest(currentGuest)
            text_total.text = guestCount.toString() + " /8"
        }
    }

    private fun showCurrentGuest(i : Int) {

        text_name.text = allGuest[i].name
        text_phone.text = allGuest[i].phone
        text_email.text = allGuest[i].email
    }

    private fun createAcitivity() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("Registered", guestRegistered.toString())
        startActivity(intent)
    }
}
