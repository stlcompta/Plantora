package com.example.plantora.data.classes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.collections.ArrayList

class AppDatabase(mContext: Context):SQLiteOpenHelper(
    mContext,
    DB_NAME,
    null,
    DB_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTableUser = """
            CREATE TABLE $USERS_TABLE_NAME (
            $USER_ID integer PRIMARY KEY,
            $MAIL varchar(50),
            $USER_CITY varchar(50)
            )
            """.trimIndent()


        val createTablePosts = """
            CREATE TABLE $POSTS_TABLE_NAME (
            $POSTS_ID integer PRIMARY KEY,
            $TITLE varchar(50),
            $DESCRIPTION text,
            $CITY varchar(50),
            $EMAIL varchar(50),
            $AUTHOR Long,
            $DATE date,
            $IMAGE blob

            )
            """.trimIndent()

        db?.execSQL(createTableUser)
        db?.execSQL(createTablePosts)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $POSTS_TABLE_NAME")
        db?.execSQL("DROP TABLE IF EXISTS $USERS_TABLE_NAME")
        onCreate(db)
    }

    fun addUser(user : User): Boolean{

        return false
    }

    fun addPost(post: Post) : Boolean{
        val db = writableDatabase
        val values = ContentValues();
        values.put(TITLE, post.title)
        values.put(DESCRIPTION, post.description)
        values.put(CITY, post.city)
        values.put(EMAIL, post.mailcontact)
        values.put(IMAGE, post.image)

        val result = db.insert(POSTS_TABLE_NAME, null, values)
        db.close()
        return result != -1L

    }

    fun findPosts(): ArrayList<Post>{
        val posts = ArrayList<Post>()
        val db = readableDatabase
        val chooseQuery = "SELECT * FROM $POSTS_TABLE_NAME"

        val cursor = db.rawQuery(chooseQuery, null)

        if(cursor != null){
            if(cursor.moveToFirst()){
                do {
                    val id = cursor.getInt(cursor.getColumnIndexOrThrow(POSTS_ID))
                    val titre = cursor.getString(cursor.getColumnIndexOrThrow(TITLE))
                    val description = cursor.getString(cursor.getColumnIndexOrThrow(DESCRIPTION))
                    val email = cursor.getString(cursor.getColumnIndexOrThrow(EMAIL))
                    val city = cursor.getString(cursor.getColumnIndexOrThrow(CITY))
                    val author = cursor.getInt(cursor.getColumnIndexOrThrow(AUTHOR))
                    val image = cursor.getBlob(cursor.getColumnIndexOrThrow(IMAGE))
                   // val post = Post(id, titre, city, email,description,author )
//                    (pid: Int, title : String,city : String, mailcontact : String, description : String, author : Int,image: ByteArray): this (pid, title, city, mailcontact, description, author , image) {
//                           this.pid = pi

                  // posts.add(cursor.moveToNext())
                }while (cursor.moveToNext())
            }
        }

        db.close()


        return posts
    }

    companion object {

        private val DB_NAME = "plantora_db"
        private val DB_VERSION = 2
        //private var INSTANCE: AppDatabase? = null

        private val POSTS_TABLE_NAME = "post"
        private val POSTS_ID = "id"
        private val TITLE = "name"
        private val DESCRIPTION = "description"
        private val EMAIL = "email"
        private val IMAGE = "image"
        private val CITY = "city"
        private val DATE = "date"
        private val AUTHOR = "author"

        private val USERS_TABLE_NAME = "user"
        private val USER_CITY = "city"
        private val USER_ID = "uid"
        private val MAIL = "mail"
    }
}

//class AppDatabase:(
//    mContext : Context,
//    name: String = "plantora_db",
//    version: Int = 1
//) : SQLiteOpenHelper(
//    mContext,
//    name,
//    null,
//    version
//
////)
//    companion object{
//
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        private val POSTS_TABLE_NAME = "posts"
//        private val POSTS_ID = "id"
//        private val TITLE = "name"
//        private val DESCRIPTION = "description"
//        private val EMAIL = "email"
//        private val IMAGE = "image"
//        private val CITY = "city"
//        private val DATE = "date"
//        private val AUTHOR = "author"
//
//
//        fun getDatabase(context: Context): AppDatabase{
//            val tempInstance = INSTANCE
//            if(tempInstance != null){
//                return tempInstance
//            }
//
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//
//        fun onCreate(db: SQLiteDatabase?){
////            val createTableUser = """
////                CREATE TABLE user (
////                $USER_ID
////            """.trimIndent()
//        }
//        val createTablePosts = """
//            CREATE TABLE $POSTS_TABLE_NAME (
//            $POSTS_ID integer PRIMARY KEY,
//            $TITLE varchar(50),
//            $DESCRIPTION text,
//            $CITY varchar(50),
//            $EMAIL varchar(50),
//            $AUTHOR Long,
//            $DATE date,
//            $IMAGE blob
//
//            )
//            """.trimIndent()
//        db?.execSQL(createTablePosts)
//
//    }
//}

//@Database(entities = [User::class, Post::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//
//    abstract fun userDao(): UserDao;
//    abstract fun postDao(): PostDao;
//
//    companion object{
//
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        private val POSTS_TABLE_NAME = "posts"
//        private val POSTS_ID = "id"
//        private val TITLE = "name"
//        private val DESCRIPTION = "description"
//        private val EMAIL = "email"
//        private val IMAGE = "image"
//        private val CITY = "city"
//        private val DATE = "date"
//        private val AUTHOR = "author"
//
//
//        fun getDatabase(context: Context): AppDatabase{
//            val tempInstance = INSTANCE
//            if(tempInstance != null){
//                return tempInstance
//            }
//
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }



