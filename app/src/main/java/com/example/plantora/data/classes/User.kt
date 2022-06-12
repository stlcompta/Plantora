package com.example.plantora.data.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid: Int,
    // @ColumnInfo(name = "first_name") val firstName: String?,
    // @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "pseudo") val pseudo: String?,
    @ColumnInfo(name = "mail") val mail: String?,
    @ColumnInfo(name = "ucity") val ucity: String?
)
