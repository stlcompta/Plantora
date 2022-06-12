package com.example.plantora.data.classes

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insertAll(vararg users: User)

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT mail FROM user WHERE uid = :id")
    fun getMail(id:Long): String

    @Query("SELECT ucity FROM user WHERE uid = :id")
    fun getVille(id:Long): String

    @Update
    fun updateUsers(vararg users: User)



//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>

//    @Query("SELECT first_name, last_name FROM user")
//    fun loadFullName(): List<NameTuple>
//
//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User


}
