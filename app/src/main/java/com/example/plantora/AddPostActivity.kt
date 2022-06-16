package com.example.plantora

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        setTheme(R.style.Theme_Plantora);
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


        imagePost.setOnClickListener {

            galleryLauncher.launch("image/*")
        }

        btnValidate.setOnClickListener {

            val titre = editTitlePost.text.toString()
            val description = editDescriptionPost.text.toString()
            val mail = editEmailPost.text.toString()
            val ville = editCityPost.text.toString()
            val author = 1
            if(titre.isEmpty() || description.isEmpty() || mail.isEmpty() || ville.isEmpty()||bitmap == null ) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT ).show();
            }else {
                Log.e("getBytes(bitmap!!) avant", getBytes(bitmap!!).size.toString())
                val imageBlob: ByteArray = compressImage(getBytes(bitmap!!))
                Log.e("imagesBlob apres", imageBlob.size.toString())
                val post = Post(titre, ville, mail, description, imageBlob, author)
                db.addPost(post)

                editCityPost.setText("")
                editTitlePost.setText("")
                editDescriptionPost.setText("")
                editEmailPost.setText("")
                bitmap = null

                finish()
            }
        }

    }

    fun getBytes(bitmap: Bitmap?): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG,0,stream)
        return stream.toByteArray()

    }

    fun compressImage(imageToCompress : ByteArray): ByteArray {
        var compressImage = imageToCompress
        while(compressImage.size > 500000){
            val bitmap = BitmapFactory.decodeByteArray(compressImage,0,compressImage.size)
            val resized = Bitmap.createScaledBitmap(bitmap, (bitmap.width * 0.8).toInt(), (bitmap.height * 0.8).toInt(),true)
            val stream = ByteArrayOutputStream()
            resized.compress(Bitmap.CompressFormat.PNG,100,stream)
            compressImage = stream.toByteArray()
        }
    return compressImage
    }
}
