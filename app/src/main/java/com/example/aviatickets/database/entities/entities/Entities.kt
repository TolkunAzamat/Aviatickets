package com.example.aviatickets.database.entities.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var idUser:Int?,
    var phoneNumber:String?,
    var password:String?
)
@Entity
data class Admin(
    @PrimaryKey(autoGenerate = true) var idAdmin:Int?,
    var phoneNumberAdmin: String="+996502025015",
    var passwordAdmin:String="tolkun2022"
        )
@Entity
data class Flights(
    @PrimaryKey(autoGenerate = true) var idFlights:Int?,
    var PointDeparture:String?,
    var Destination:String?,
    var dateDeparture:String?,
    var timeDeparture:String?,
    var timeLanding:String?
    )
@Entity
data class Passengers(
    @PrimaryKey(autoGenerate = true) var idPassengers:Int?,
    var fnamePassengers:String?,
    var lnamePassengers:String?,
    var passport:String?
    )
@Entity
data class Tickets(
    @PrimaryKey(autoGenerate = true) var idTicket:Int?,
    var fnamePassengers:String?,
    var lnamePassengers: String?,
    var passport:String?

)