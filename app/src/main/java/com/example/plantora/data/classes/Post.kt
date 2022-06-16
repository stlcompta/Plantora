package com.example.plantora.data.classes

data class Post(
    var title: String,
    var city: String,
    var mailcontact: String,
    var description: String,
    var image: ByteArray,
    var author: Int

) {

    var pid: Int = -1

   constructor(pid: Int, title : String,city : String, mailcontact : String, description : String, author : Int,image: ByteArray): this (title, city, mailcontact, description, image, author) {
        this.pid = pid
    }
}


//ROOM
// @Entity(tableName = "post",foreignKeys = [
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
//    val author: Long?
//
//    )
