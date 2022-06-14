package com.example.plantora

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
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
            intentImg.type = "image/*"
            startActivityForResult(intentImg, 100)
        }

        btnValidate.setOnClickListener{

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100 && resultCode == RESULT_OK){
          val uri: Uri? = data?.data
            val inputStream = contentResolver.openInputStream(uri!!)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            imagePost.setImageBitmap(bitmap)
        }


    }
}