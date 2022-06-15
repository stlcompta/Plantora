package com.example.plantora.data.classes

import android.graphics.Bitmap
import android.widget.EditText
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*


data class Post(
    var title: String,
    var city: String,
    var mailcontact: String,
    var description: String,
    var image: ByteArray

)


//@Entity(tableName = "post",foreignKeys = [
//    ForeignKey(entity = User::class,
//        parentColumns = arrayOf("uid"),
//        childColumns = arrayOf("author"),
//        onDelete = ForeignKey.CASCADE)])
//data class Post(
//    @PrimaryKey val pid: Int,
//    @ColumnInfo(name = "title") val title: String?,
//    @ColumnInfo(name = "city") val city: String?,
//    @ColumnInfo(name = "mailcontact") val mailcontact: String?,
//    @ColumnInfo(name = "description") val description: String?,
//    @ColumnInfo(name = "picture") val picture: Bitmap?,
//    @ColumnInfo(name = "date") val date: Date?,
//    val author: Long?
//
//    )
