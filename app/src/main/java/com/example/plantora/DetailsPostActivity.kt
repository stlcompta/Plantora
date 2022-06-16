package com.example.plantora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_post)

        val tvTitre = findViewById<TextView>(R.id.tvTitre)
        val titre = intent.getStringExtra("titre")
        tvTitre.text = titre

    }
}