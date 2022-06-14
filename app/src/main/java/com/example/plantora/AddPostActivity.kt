package com.example.plantora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class AddPostActivity : AppCompatActivity() {

    lateinit var btnValidate: Button
    lateinit var editTitlePost: EditText
    lateinit var editDescriptionPost: EditText
    lateinit var editCityPost: EditText
    lateinit var editEmailPost: EditText
    lateinit var imagePost: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)


        btnValidate = findViewById(R.id.btnValidate)
        editTitlePost = findViewById(R.id.editTitlePost)
        editDescriptionPost = findViewById(R.id.editDescriptionPost)
        editCityPost = findViewById(R.id.editCityPost)
        editEmailPost = findViewById(R.id.editEmailPost)
        imagePost = findViewById(R.id.imagePost)

        imagePost.setOnClickListener{

            val intentImg = Intent(Intent.ACTION_GET_CONTENT)
            intentImg.type = "images/*"
            startActivity(intentImg)
        }

        btnValidate.setOnClickListener{

        }
    }
}