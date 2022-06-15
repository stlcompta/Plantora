package com.example.plantora

import PostAdaptor
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.plantora.data.classes.AppDatabase
import com.example.plantora.data.classes.Post
import java.io.ByteArrayOutputStream

class AddPostActivity : AppCompatActivity() {

    lateinit var btnValidate: Button
    lateinit var editTitlePost: EditText
    lateinit var editDescriptionPost: EditText
    lateinit var editCityPost: EditText
    lateinit var editEmailPost: EditText
    lateinit var imagePost: ImageView
    lateinit var db: AppDatabase
    var bitmap: Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        db = AppDatabase(this)

        btnValidate = findViewById(R.id.btnValidate)
        editTitlePost = findViewById(R.id.editTitlePost)
        editDescriptionPost = findViewById(R.id.editDescriptionPost)
        editCityPost = findViewById(R.id.editCityPost)
        editEmailPost = findViewById(R.id.editEmailPost)
        imagePost = findViewById(R.id.imagePost)

        val galleryLauncher =
            registerForActivityResult(ActivityResultContracts.GetContent()) { data ->
                val inputStream = contentResolver.openInputStream(data)
                bitmap = BitmapFactory.decodeStream(inputStream)
                imagePost.setImageBitmap(bitmap)
            }

        val listPosts = findViewById<ListView>(R.id.)
        val adapter = PostAdaptor(this, R.layout.item_post,postsArray)
        listPosts.adapter = adapter

        imagePost.setOnClickListener {

            val intentImg = Intent(Intent.ACTION_GET_CONTENT)
            intentImg.type = "image/*"
            startActivityForResult(intentImg, 100)
        }

        btnValidate.setOnClickListener {

            val titre = editTitlePost.toString()
            val description = editDescriptionPost.toString()
            val mail = editEmailPost.toString()
            val ville = editCityPost.toString()
            val imageBlob : ByteArray = getBytes(bitmap!!)

            val post = Post(titre, description, mail, ville, imageBlob)
            db.addPost(post)
        }

//        btnValidate.setOnClickListener{
//
//        }
    }

    fun getBytes(bitmap: Bitmap?): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG,0,stream)
        return stream.toByteArray()

    }
}

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == 100 && resultCode == RESULT_OK){
//          val uri: Uri? = data?.data
//            val inputStream = contentResolver.openInputStream(uri!!)
//            val bitmap = BitmapFactory.decodeStream(inputStream)
//            imagePost.setImageBitmap(bitmap)
//        }
//
//
//    }
//}