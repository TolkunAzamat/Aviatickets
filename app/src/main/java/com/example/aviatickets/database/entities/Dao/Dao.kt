package com.example.aviatickets.database.entities.Dao

import androidx.room.*
import androidx.room.Dao
import com.example.aviatickets.database.entities.entities.*

@Dao
interface Dao {
    //User
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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAdmin(vararg admin: Admin)

   //Admin
    @Query("SELECT * FROM Admin where phoneNumberAdmin=:phoneA")
    fun getAdminNumber(phoneA:String):Admin
    @Query("SELECT passwordAdmin FROM Admin where passwordAdmin=:passwordA")
    fun getAdminPassword(passwordA:String):String

    //Flights
    @Insert
    fun insertFlight(flights: Flights)
    @Query("SELECT arriving FROM Flights where arriving=:arr")
    fun getArriving(arr:String):String

    @Query("SELECT arriving FROM Flights")
    fun getAllArriving():List<String>

    @Query("SELECT departing FROM Flights")
    fun getAllDeparting():List<String>

    @Query("SELECT departing FROM Flights where departing=:dep")
    fun getDeparting(dep:String):String


    @Delete
    fun deleteCurrent(flights: Flights)
    @Update
    fun updateTicket(flights: Flights)

    @Query("SELECT * FROM Flights where departing=:dep AND arriving=:arr ")
    fun getAllFlight(arr: String,dep: String): Flights

    @Query("SELECT * FROM Flights ")
    fun getAllFlights(): List<Flights>



}