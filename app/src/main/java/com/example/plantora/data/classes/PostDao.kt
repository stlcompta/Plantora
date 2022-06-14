package com.example.plantora.data.classes

import android.graphics.Bitmap
import androidx.room.*

@Dao
interface PostDao {

    @Insert
    fun insertAll(vararg posts: Post)

    @Insert
    fun insert(post: Post)

    @Delete
    fun delete(post: Post)

    @Query("SELECT * FROM post")
    fun getAll(): List<Post>

    @Query("SELECT * FROM post ORDER BY date DESC LIMIT 20 ")
    fun getNewPosts(): List<Post>

    @Query("SELECT * FROM post WHERE author = :auteur")
    fun getMyPosts(auteur:Long): List<Post>

    @Query("SELECT * FROM post WHERE city LIKE :search OR title LIKE :search OR city LIKE :search OR mailcontact LIKE :search " +
            "OR description LIKE :search")
    fun getPostsResearch(search:String): List<Post>

    @Query("UPDATE post SET title = :titre, city = :ville, mailcontact = :email, description = :desc, picture = :photo\n" +
            "WHERE pid = :id")
    fun editPost(titre:String, ville:String,email:String,desc:String,photo:Bitmap, id:Long): List<Post>

    @Query("DELETE FROM post WHERE pid = :idpost")
    fun deletePost(idpost:Long): List<Post>

    @Update
    fun updatePosts(vararg posts: Post)

//    @Query("SELECT * FROM post WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>

}