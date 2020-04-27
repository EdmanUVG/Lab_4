package com.example.lab_4.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab_4.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val guests: String = intent.getStringExtra("Registered")
        val registered = "Registrados: "

        val guestRegistered = "$registered  $guests"

        this.text_registered.text = guestRegistered
    }
}
