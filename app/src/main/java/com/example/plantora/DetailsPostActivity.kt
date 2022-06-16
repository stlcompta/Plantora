package com.example.plantora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Plantora);
        setContentView(R.layout.activity_details_post)
        val tvTitrePost = findViewById<TextView>(R.id.tvPostTitre)
        val title = intent.getStringExtra("title")
        tvTitrePost.text = title
//
//        supportActionBar!!.title = title

    }
}