package com.example.plantora.data.classes

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "post",foreignKeys = [
    ForeignKey(entity = User::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("author"),
        onDelete = ForeignKey.CASCADE)])
data class Post(
    @PrimaryKey val pid: Int,
    @ColumnInfo(name = "title") val plantName: String?,
    @ColumnInfo(name = "city") val city: String?,
    @ColumnInfo(name = "mail") val mail: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "picture") val picture: Bitmap?,
    @ColumnInfo(name = "date") val date: Date?,
    val author: Long?

    )
