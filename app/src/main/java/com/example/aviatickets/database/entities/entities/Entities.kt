package com.example.aviatickets.database.entities.entities

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var idUser:Int?,
    var phoneNumber:String?,
    var password:String?
)
@Entity
data class Admin(
    @PrimaryKey(autoGenerate = true)
    var idAdmin:Int?,
    var phoneNumberAdmin: String?,
    var passwordAdmin:String?
        )

@Parcelize
@Entity
data class Flights(
    @PrimaryKey(autoGenerate = true)var idFlights:Int?,
   var flightName:String?,
   var departing:String?,
   var arriving:String?,
   var dateDeparting:Date?,
   var dateArriving:Date?,
   var planeName: String?,
    var price:Int?
): Parcelable
