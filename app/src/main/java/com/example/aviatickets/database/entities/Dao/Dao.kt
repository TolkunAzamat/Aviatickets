package com.example.aviatickets.database.entities.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aviatickets.database.entities.entities.User

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(vararg user: User)

    @Query("SELECT * FROM User")
    fun getAllUsers(): Array<User>

    @Query("SELECT phoneNumber FROM User")
    fun getPhoneNumbers(): List<String>

    @Query("SELECT password FROM User")
    fun getPasswords(): List<String>
    @Query("SELECT * FROM User where phoneNumber=:phoneU")
    fun getUserNumbers(phoneU:String):User
    @Query("SELECT password FROM User where password=:passwordU")
    fun getUserPasswords(passwordU:String):String
}