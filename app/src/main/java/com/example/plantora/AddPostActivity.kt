package com.example.plantora

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
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

//        val listPosts = findViewById<ListView>(R.id.)
//        val adapter = PostAdaptor(this, R.layout.recycler_item_accueil,postsArray)
//        listPosts.adapter = adapter

        imagePost.setOnClickListener {

            galleryLauncher.launch("image/*")
//            val intentImg = Intent(Intent.ACTION_GET_CONTENT)
//            intentImg.type = "image/*"
//            startActivityForResult(intentImg, 100)
        }

        btnValidate.setOnClickListener {

            val titre = editTitlePost.toString()
            val description = editDescriptionPost.toString()
            val mail = editEmailPost.toString()
            val ville = editCityPost.toString()
            if(titre.isEmpty() || description.isEmpty() || mail.isEmpty() || ville.isEmpty()||bitmap == null ) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT ).show();
            }else {
                val imageBlob: ByteArray = getBytes(bitmap!!)

                //val post = Post(titre, description, mail, ville, imageBlob)
                //db.addPost(post)

                editCityPost.setText("")
                editTitlePost.setText("")
                editDescriptionPost.setText("")
                editEmailPost.setText("")
                bitmap = null

                finish()
            }
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