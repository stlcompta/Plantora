package com.example.plantora.data.classes

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao,
    abstract fun postDao(): PostDao
}
